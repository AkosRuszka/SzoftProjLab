package vasut;

public class Sin {
	private Sin aPoint;
	private Sin bPoint;
	private VonatElem actVonatElem;
	private boolean dir;
	
	public Sin(Sin aPoint_){
		/** Megkapja az egyik már létrehozott oldalát */
		aPoint = aPoint_;
		bPoint = null;
		actVonatElem = null;
	}
	public Sin getAPoint() {
		return aPoint;
		/** Lekérdezi az aPontot */
	}
	public Sin getBPoint() {
		return aPoint;
		/** Lekérdezi a bPontot */
	}
	public void setAPoint(Sin ap) {
		/** Beállítja az aPontot */
	}
	public void setBPoint(Sin bp) {
		/** Beállítja a bPontot */
	}
	public void setActVonatElem(VonatElem akt) {
		/** Beállítjuk a actVonatElem-et */
	}
	public VonatElem getActVonatElem() {
		/** Lekérdezzük az actVonatElem-et */
	}
	public Sin actMove() {
		/** Továbbrakjuk az actVonatElem-et */
	}
}
