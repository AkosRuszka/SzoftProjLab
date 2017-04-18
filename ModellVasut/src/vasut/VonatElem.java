package vasut;

import java.io.IOException;
import java.io.Serializable;

public class VonatElem implements Serializable{
	Sin whereAmI;
	VonatElem frontElem;
	Kocsi backElem;
	String color;
	boolean empty = false;
	boolean emptyable = false;
	
	public VonatElem(Sin whereAmI_, VonatElem frontElem_, Kocsi backElem_, String color_){
		whereAmI = whereAmI_;
		frontElem = frontElem_;
		backElem = backElem_;
		color = color_;
	}
	
	//itt majd meg kell valósítani a felszálláskor átállítódást :D
	// Fél óra folyamatos szekvenciadiagram szugerálás után arra jutottam, hogy én ezt nem értem
	public void changeColor() {
		if(emptyable){
			empty = true;
		}
	}

	public Sin getWhereAmI() {
		/** Lekérdezzük az aktuális tartózkodási helyét */
		return whereAmI;
	}
	
	public void setWhereAmI(Sin elem) {
		/** Beállítja az aktuális tartózkodási helyét */
		whereAmI = elem;
	}
	
	public void setFrontElem(VonatElem frontElem_) {
		/** Beállítja az előtte álló VonatElem-re mutató referenciát */
		frontElem = frontElem_;
	}
	
	public void setBackElem(Kocsi backElem_) {
		/** Beállítja az mögötte álló VonatElem-re mutató referenciát */
		backElem = backElem_;
	}
	
	public String getColor() {
		/** Visszaadja az adott Kocsi színét. */
		return color;
	}
	
	public boolean getEmpty() { //ez már nem hiszem h kell
		return empty;
	}
	
	public void setEmpty(boolean bool) {
		empty = bool;
	}
}