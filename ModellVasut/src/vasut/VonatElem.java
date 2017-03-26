package vasut;

import java.io.IOException;

public class VonatElem {
	Sin whereAmI;
	VonatElem frontElem;
	VonatElem backElem;
	String color;
	
	public VonatElem(Sin whereAmI_, VonatElem frontElem_, VonatElem backElem_, String color_){
		whereAmI = whereAmI_;
		frontElem = frontElem_;
		backElem = backElem_;
		color = color_;
	}
	public VonatElem(){}
	
	public void changeColor() {
		/** Beállítja a kocsi színét szürkére, az előtte álló kocsi színétől függően. */
		
		System.out.println("VonatElem: Meghívódott a színváltás függvényem. Megkérdezem az előző kocsim színét");
		new VonatElem().getColor();
		System.out.println("VonatElem: Szürke ez a szín?");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) 
				System.out.println("VonatElem: Megváltozott a színem szürkére.");
			else
				System.out.println("VonatElem: Nem változott semmi");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Sin getWhereAmI() {
		/** Lekérdezzük az aktuális tartózkodási helyét */
		System.out.println("VonatElem: Lekérdezzük, melyik sínen vagyunk.");
		return null;
	}
	
	public void setWhereAmI(Sin elem) {
		/** Beállítja az aktuális tartózkodási helyét */
		System.out.println("VonatElem: Beállítottuk az aktuális sínünket.");
	}
	
	public void setFrontElem(VonatElem frontElem) {
		/** Beállítja az előtte álló VonatElem-re mutató referenciát */
		System.out.println("VonatElem: Beállítottuk az előttem álló vonatelemet.");
	}
	
	public void setBackElem(VonatElem backElem) {
		/** Beállítja az mögötte álló VonatElem-re mutató referenciát */
		System.out.println("VonatElem: Beállítottuk a mögöttem álló vonatelemet.");
	}
	
	public String getColor() {
		/** Visszaadja az adott Kocsi színét. */
		System.out.println("VonatElem: Lekérdezzük a vonatelem színét");
		return null;
	}
}