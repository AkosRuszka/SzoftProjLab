package vasut;

import java.io.Serializable;

public class Sin implements Serializable{
	protected VonatElem actVonatElem;
	protected Sin aPoint;		/** Sin mögötti elem */
	protected Sin bPoint;		/** Sin előtti elem */
	protected Sin crossing;		/** Felette levő sín elem, kereszteződéseknél */
	protected boolean dir; 		/** Aktuális menetirány (true esetén bPoint)*/

	public Sin(Sin aPoint_){
		/** Megkapja az előtte lévő sínt, többit nullázza. */
		dir = true;
		actVonatElem = null;
		aPoint = aPoint_;
		aPoint.setBPoint(this); /** Beállítja az előtte álló elem bPoint-ját magára. */
		bPoint = null;
	}
	
	/* Ezt majd ki kell szedni, csak a sintax error miatt van még benne!!! */
	public Sin() {
		/* Üres konstruktor */
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
	
	/** Visszaadjuk hogy merre mehet a vonat */
	public Sin actMove() throws Exception {
		//System.out.println("Sin: actMove() függvényt meghívták.");
		
		VonatElem ap = aPoint.getActVonatElem();
		VonatElem bp = bPoint.getActVonatElem();
		
		/** Ha semelyik irányba nincs kocsi akkor a dir alapján döntünk */
		if(ap == null && bp == null) {
			if(dir) {
				return bPoint;
			} else {
				return aPoint;
			}
		} else if(ap == null) { 	/** Megvizsgáljuk merre menjen a vonat normális esetben */
			dir = false;
			return aPoint;
		} else if(bp == null) {
			dir = true;
			return bPoint;
		}
		
		 /** Ha idáig eljutottunk akkor mindkét irányba van kocsi és ütközés történik! */
		throw new Exception("Ütközés történt");
	}
}