package vasut;

import java.io.IOException;

public class VonatElem {
	
	public VonatElem(){};
	
	public void changeColor() {
		/** Beállítja a kocsi színét szürkére, az előtte álló kocsi színétől függően. */
		
		System.out.println("Meghívódott a színváltás függvényem. Megkérdezem az előző kocsim színét");
		new VonatElem().getColor();
		System.out.println("Szürke ez a szín?");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) 
				System.out.println("Megváltozott a színem szürkére.");
			else
				System.out.println("Nem változott semmi");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
