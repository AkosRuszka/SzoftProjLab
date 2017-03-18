package vasut;

public class Sin {

	public Sin(Sin aPoint_){
		/** Megkapja az egyik m�r l�trehozott oldal�t, t�bbit null�zza. */

	}
	public Sin getAPoint() {
		/** Lek�rdezi az aPontot */
		System.out.println("Lek�rdezz�k az A pontot.");
		return aPoint;
	}
	public Sin getBPoint() {
		/** Lek�rdezi a bPontot */
		System.out.println("Lek�rdezz�k a B pontot.");
		return new Sin(this);
	}
	public void setAPoint(Sin ap) {
		/** Be�ll�tja az aPontot */
		System.out.println("Be�ll�tjuk az A pontot.");
	}
	public void setBPoint(Sin bp) {
		/** Be�ll�tja a bPontot */
		System.out.println("Be�ll�tjuk a B pontot.");
	}
	public void setActVonatElem(VonatElem akt) {
		/** Be�ll�tjuk a actVonatElem-et */
		System.out.println("Be�ll�tjuk a Sin-en l�v� Mozdonyt.");
	}
	public VonatElem getActVonatElem() {
		/** Lek�rdezz�k az actVonatElem-et */
		System.out.println("Lek�rdezz�k a Sin-en l�v� Mozdonyt.");
		return actVonatElem;
	}
	public Sin actMove() {
		/** Tov�bbrakjuk az actVonatElem-et */
		System.out.println("Megh�v�dott az actMove() f�ggv�ny.");
	}
}
