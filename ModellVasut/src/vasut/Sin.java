package vasut;

public class Sin {
	protected VonatElem actVonatElem;
	protected Sin aPoint;		/** Sin mögötti elem */
	protected Sin bPoint;		/** Sin előtti elem */
	protected boolean dir; 	/** Aktuális menetirány (true esetén bPoint)*/

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
	
	
	public Sin getAPoint() {
		/** Lekérdezi az aPontot */
		System.out.println("Sin: A pont lekérdezése");
		return aPoint;
	}
	public Sin getBPoint() {
		/** Lekérdezi a bPontot */
		System.out.println("Sin: B pont lekérdezése");
		return bPoint;
	}
	public void setAPoint(Sin ap) {
		/** Beállítja az aPontot */
		System.out.println("Sin: A pont beállítása.");
		aPoint = ap;
	}
	public void setBPoint(Sin bp) {
		/** Beállítja a bPontot */
		System.out.println("Sin: B pont beállítása.");
		bPoint = bp;
	}
	public void setActVonatElem(VonatElem akt) {
		/** Beállítjuk a actVonatElem-et */
		System.out.println("Sin: mozdony beállítása.");
		actVonatElem = akt;
	}
	public VonatElem getActVonatElem() {
		/** Lekérdezzük az actVonatElem-et */
		System.out.println("Sin: mozdony lekérdezése");
		return actVonatElem;
	}
	public Sin actMove() throws Exception {
		/** Visszaadjuk hogy merre mehet a vonat */
		System.out.println("Sin: actMove() függvényt meghívták.");
		
		VonatElem ap = aPoint.getActVonatElem();
		VonatElem bp = bPoint.getActVonatElem();
		
		/* Ha semelyik irányba nincs kocsi akkor a dir alapján döntünk */
		if(ap == null && bp == null) {
			if(dir) {
				return bPoint;
			} else {
				return aPoint;
			}
		} else if(ap == null) { 	/* Megvizsgáljuk merre menjen a vonat normális esetben */
			dir = false;
			return aPoint;
		} else if(bp == null) {
			dir = true;
			return bPoint;
		}
		
		 /* Ha idáig eljutottunk akkor mindkét irányba van kocsi és ütközés történik! */
		throw new Exception("Ütközés történt");
	}
}