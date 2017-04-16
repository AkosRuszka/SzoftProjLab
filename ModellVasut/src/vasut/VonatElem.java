package vasut;

import java.io.IOException;
import java.io.Serializable;

public class VonatElem implements Serializable{
	Sin whereAmI;
	VonatElem frontElem;
	Kocsi backElem;
	String color;
	boolean empty = false;
	
	public VonatElem(Sin whereAmI_, VonatElem frontElem_, Kocsi backElem_, String color_){
		whereAmI = whereAmI_;
		frontElem = frontElem_;
		backElem = backElem_;
		color = color_;
	}
	
	//itt majd meg kell valósítani a felszálláskor átállítódást :D
	// Fél óra folyamatos szekvenciadiagram szugerálás után arra jutottam, hogy én ezt nem értem
	public void changeColor() {
		System.out.println("VonatElem: Meghívódott a színváltás függvényem");
		if(frontElem.getEmpty()){
			color = "grey";
			empty = true;
			System.out.println("VonatElem: Megváltozott a színem szürkére.");
		}
		else{
			System.out.println("VonatElem: Nem változott semmi");
		}
	}

	public Sin getWhereAmI() {
		/** Lekérdezzük az aktuális tartózkodási helyét */
		System.out.println("VonatElem: Lekérdezzük, melyik sínen vagyunk.");
		return whereAmI;
	}
	
	public void setWhereAmI(Sin elem) {
		/** Beállítja az aktuális tartózkodási helyét */
		System.out.println("VonatElem: Beállítottuk az aktuális sínünket.");
		whereAmI = elem;
	}
	
	public void setFrontElem(VonatElem frontElem_) {
		/** Beállítja az előtte álló VonatElem-re mutató referenciát */
		System.out.println("VonatElem: Beállítottuk az előttem álló vonatelemet.");
		frontElem = frontElem_;
	}
	
	public void setBackElem(Kocsi backElem_) {
		/** Beállítja az mögötte álló VonatElem-re mutató referenciát */
		System.out.println("VonatElem: Beállítottuk a mögöttem álló vonatelemet.");
		backElem = backElem_;
	}
	
	public String getColor() {
		/** Visszaadja az adott Kocsi színét. */
		System.out.println("VonatElem: Lekérdezzük a vonatelem színét");
		return color;
	}
	
	public boolean getEmpty() {
		return empty;
	}
	
	public void setEmpty(boolean bool) {
		empty = bool;
	}
}