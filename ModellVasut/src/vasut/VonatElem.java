package vasut;

public class VonatElem {
	
	public VonatElem(){};

	public Sin getWhereAmI() {
		/** Lekérdezzük az aktuális tartózkodási helyét */
		System.out.println("Lekérdezzük, melyik sínen vagyunk.");
		return null;
	}
	
	public void setWhereAmI(Sin elem) {
		/** Beállítja az aktuális tartózkodási helyét */
		System.out.println("Beállítottuk az aktuális sínünket.");
	}
	
	public void setFrontElem(VonatElem frontElem) {
		/** Beállítja az előtte álló VonatElem-re mutató referenciát */
		System.out.println("Beállítottuk az előttem álló vonatelemet.");
	}
	
	public void setBackElem(VonatElem backElem) {
		/** Beállítja az mögötte álló VonatElem-re mutató referenciát */
		System.out.println("Beállítottuk a mögöttem álló vonatelemet.");
	}
	
	public String getColor() {
		/** Visszaadja az adott Kocsi színét. */
		System.out.println("Lekérdezzük a vonatelem színét");
		return null;
	}
}
