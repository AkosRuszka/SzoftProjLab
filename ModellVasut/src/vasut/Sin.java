package vasut;

public class Sin {
	private Sin aPoint;
	private Sin bPoint;
	private VonatElem actVonatElem;
	private boolean dir;
	
	public Sin(Sin aPoint_){
		/** Megkapja az egyik m�r l�trehozott oldal�t */
		aPoint = aPoint_;
		bPoint = null;
		actVonatElem = null;
	}
	public Sin getAPoint() {
		return aPoint;
		/** Lek�rdezi az aPontot */
	}
	public Sin getBPoint() {
		return aPoint;
		/** Lek�rdezi a bPontot */
	}
	public void setAPoint(Sin ap) {
		/** Be�ll�tja az aPontot */
	}
	public void setBPoint(Sin bp) {
		/** Be�ll�tja a bPontot */
	}
	public void setActVonatElem(VonatElem akt) {
		/** Be�ll�tjuk a actVonatElem-et */
	}
	public VonatElem getActVonatElem() {
		/** Lek�rdezz�k az actVonatElem-et */
	}
	public Sin actMove() {
		/** Tov�bbrakjuk az actVonatElem-et */
	}
}
