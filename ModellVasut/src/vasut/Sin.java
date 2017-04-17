package vasut;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Sin implements Serializable{
	
	private static final Logger Log = LogManager.getLogger(Sin.class);
	
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
		aPoint.setBPoint(this); /** Beállítja az előtte álló elem bPoint-ját magára. */
		bPoint = null;
		crossing = null;
	}
	
	/** Lekérdezi az aPontot */
	public Sin getAPoint() {
		//System.out.println("Sin: A pont lekérdezése");
		return aPoint;
	}
	
	/** Lekérdezi a bPontot */
	public Sin getBPoint() {
		//System.out.println("Sin: B pont lekérdezése");
		return bPoint;
	}
	
	/** Beállítja az aPontot */
	public void setAPoint(Sin ap) {
		//System.out.println("Sin: A pont beállítása.");
		aPoint = ap;
	}
	
	/** Beállítja a bPontot */
	public void setBPoint(Sin bp) {
		//System.out.println("Sin: B pont beállítása.");
		bPoint = bp;
	}
	
	/** Beállítjuk a actVonatElem-et */
	public void setActVonatElem(VonatElem akt) {	
		//System.out.println("Sin: mozdony beállítása.");
		actVonatElem = akt;
	}
	
	/** Lekérdezzük az actVonatElem-et */
	public VonatElem getActVonatElem() {
		//System.out.println("Sin: mozdony lekérdezése");
		return actVonatElem;
	}
	
	public void setCrossing(Sin cross) {
		crossing = cross;
	}
	public Sin getCrossing(){
		return crossing;
	}
	
	/** Visszaadjuk hogy merre mehet a vonat */
	public Sin actMove() throws Exception {
		
		Log.info("actMove() meghívva.");
		
		//System.out.println("Sin: actMove() függvényt meghívták.");
		VonatElem ap = aPoint.getActVonatElem();
		VonatElem bp = bPoint.getActVonatElem();
		
		/** Megvizsgáljuk hogy a bp (következő sín) felett levő sínen (ha van ilyen) van e vonatElem */
		VonatElem bp_crossing;
		if(bPoint.getCrossing() != null) {
			bp_crossing = bPoint.getCrossing().getActVonatElem();
		} else {
			bp_crossing = null;
		}
		
		VonatElem ap_crossing;
		if(aPoint.getCrossing() != null) {
			ap_crossing = bPoint.getCrossing().getActVonatElem();
		} else { 
			ap_crossing = null;
		}
			
		/** Ha semelyik irányba nincs kocsi akkor a dir alapján döntünk */
		if(ap == null && bp == null) {
			if(dir) {
				/** Ha dir alapján bPoint felé megyünk tovább, akkor nézzük a bPoint felett található sín-en levő actVonatElem-et  */
				if(bp_crossing == null) {
					return bPoint;
				}
			} else {
				/** Ha dir alapján aPoint felé megyünk tovább, akkor nézzük az aPoint felett található sín-en levő actVonatElem-et  */
				if(ap_crossing == null) {
					return aPoint;	
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
		
		Log.info("Exception(Ütközés történt)");
		 /** Ha idáig eljutottunk akkor mindkét irányba van kocsi és ütközés történik! */
		throw new Exception("Ütközés történt");
	}
}