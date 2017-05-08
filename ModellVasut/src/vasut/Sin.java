package vasut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Sin implements Serializable{
	
	private static final Logger Log = LogManager.getLogger(Sin.class);
	
	/* Rá feliratkozott */
	private List<ActionListener> list = new ArrayList();
	
	protected VonatElem actVonatElem;
	/** Sin mögötti elem */
	protected Sin aPoint;	
	/** Sin előtti elem */
	protected Sin bPoint;	
	/** Felette levő sín elem, kereszteződéseknél */
	protected Sin crossing;		
	/** Aktuális menetirány (true esetén bPoint)*/
	protected boolean dir; 	

	public Sin(Sin aPoint_){
		Log.info("Sin konstruktor meghívva.");
		/** Megkapja az előtte lévő sínt, többit nullázza. */
		dir = true;
		actVonatElem = null;
		aPoint = aPoint_;
		if(aPoint != null)
			aPoint.setBPoint(this); /** Beállítja az előtte álló elem bPoint-ját magára. */
		bPoint = null;
		crossing = null;
	}
	
	/** Lekérdezi az aPontot */
	public Sin getAPoint() {
		return aPoint;
	}
	
	/** Lekérdezi a bPontot */
	public Sin getBPoint() {
		return bPoint;
	}
	
	/** Listenerek felvétele */
	public void addActionListener(ActionListener listener) {
		list.add(listener);
	}
	
	/** Váltó által meghívott setApoint (amikor elsütjük az eventet) */
	public void setAPoint_Valto(Sin ap) {
		aPoint = ap;
		/* Event jelzés */
		for(ActionListener act : list) {
			if(ap == null) {
				act.actionPerformed(new ActionEvent(this,0,"AP_INACTIV"));
			} else {
				act.actionPerformed(new ActionEvent(this,1,"AP_ACTIVE"));
			}
		}
	}
	
	/** Váltó által meghívott setBpoint (amikor elsütjük az eventet) */
	public void setBPoint_Valto(Sin bp) {
		bPoint = bp;
		/* Event jelzés */
		for(ActionListener act : list) {
			if(bp == null) {
				act.actionPerformed(new ActionEvent(this,2,"BP_INACTIV"));
			} else {
				act.actionPerformed(new ActionEvent(this,3,"BP_ACTIVE"));
			}
		}
	}
	
	/** Beállítja az aPontot */
	public void setAPoint(Sin ap) {
		aPoint = ap;
	}
	
	/** Beállítja a bPontot */
	public void setBPoint(Sin bp) {
		bPoint = bp;
	}
	
	/** Beállítjuk a actVonatElem-et */
	public void setActVonatElem(VonatElem akt) {	
		actVonatElem = akt;
	}
	
	/** Lekérdezzük az actVonatElem-et */
	public VonatElem getActVonatElem() {
		return actVonatElem;
	}
	
	/** Felette levő elem beállítása (kereszteződés) */
	public void setCrossing(Sin cross) {
		crossing = cross;
	}
	
	/** Felette levő elem lekérdezése (kereszteződés) */
	public Sin getCrossing(){
		return crossing;
	}
	
	/** Visszaadjuk hogy merre mehet a vonat */
	public Sin actMove() throws Exception {
		
		Log.info("actMove() meghívva.");
		
		/* Error: null.getActVonatElem() lehetséges... */
		VonatElem ap;
		VonatElem ap_crossing;
		if(aPoint != null) {
			ap = aPoint.getActVonatElem();
			/** Megvizsgáljuk hogy a ap (következő sín) felett levő sínen (ha van ilyen) van e vonatElem */
			if(aPoint.getCrossing() != null) {
				ap_crossing = bPoint.getCrossing().getActVonatElem();
			} else { 
				ap_crossing = null;
			}
		} else {
			ap = null;
			ap_crossing = null;
		}
		
		VonatElem bp;
		VonatElem bp_crossing;
		if(bPoint != null) {
			bp = bPoint.getActVonatElem();
			/** Megvizsgáljuk hogy a bp (következő sín) felett levő sínen (ha van ilyen) van e vonatElem */
			if(bPoint.getCrossing() != null) {
				bp_crossing = bPoint.getCrossing().getActVonatElem();
			} else {
				bp_crossing = null;
			}
		} else {
			bp = null;
			bp_crossing = null;
		}
			
		/** Ha semelyik irányba nincs kocsi akkor a dir alapján döntünk , de itt még lehet az aPoint vagy bPoint null...*/
		if(ap == null && bp == null) {
			if(dir) {
				/** Ha dir alapján bPoint felé megyünk tovább, akkor nézzük a bPoint felett található sín-en levő actVonatElem-et  */
				if(bp_crossing == null) {
					return bPoint;
				} 
				/* Ha bp_crossing != null akkor van felette VonatElem, ezért ütközés történik. */
				else {
					Log.info("Exception(Ütközés történt) dobás");
					throw new Exception("Ütközés történt");
				}
			} else {
				/** Ha dir alapján aPoint felé megyünk tovább, akkor nézzük az aPoint felett található sín-en levő actVonatElem-et  */
				if(ap_crossing == null) {
					return aPoint;	
				}
				else {
					Log.info("Exception(Ütközés történt) dobás");
					throw new Exception("Ütközés történt");
				}
			}
		/** Megvizsgáljuk merre menjen a vonat normális esetben (tehát nem az actVonatElem a vonat utolsó kocsija...)
		 * 	Ha az xPoint-on nincs kocsi akkor arra küldenénk tovább az actVonatElem-et de mellé még megvizsgáljuk hogy
		 *  az xPoint felett levő (ha van) sínen van e Vonat, csak akkor térünk vissza az xPoint-al ha mindkét feltétel teljesül
		 * */
		} else if(ap == null && ap_crossing == null) { 	
			dir = false;
			return aPoint;
		} else if(bp == null && bp_crossing == null) {
			dir = true;
			return bPoint;
		}
		
		/* Idáig állítólag sose jutunk el... */
		
		Log.info("Exception(Ütközés történt) dobás");
		Log.info("---------------------------------------------------------------");
		/** Ha idáig eljutottunk akkor mindkét irányba van kocsi és ütközés történik! */
		throw new Exception("Ütközés történt");
	}
}
