package vasut;

import java.io.IOException;
import java.io.Serializable;
import org.apache.log4j.*;

public class VonatElem implements Serializable{
	Sin whereAmI;
	VonatElem frontElem;
	Kocsi backElem;
	String color;
	boolean empty = false;
	boolean emptyable = false;
	
	//Logoláshoz
	private static final Logger log = LogManager.getLogger(VonatElem.class);
	
	public VonatElem(Sin whereAmI_, VonatElem frontElem_, String color_){
		whereAmI = whereAmI_;
		frontElem = frontElem_;
		color = color_;
		if(color == "grey"){//szeneskocsi :D
			empty=true;
			emptyable=true;
		}
		
		log.info("VonatElem konstruktora meghívva");
	}
	
	public void changeColor() { //Az állomás leszálláskor hívja ezt a függvényt
		//Log
		log.info("VonatElem: changeColor meghívva");
		if(emptyable||frontElem.getColor()=="grey"){
			empty = true;
			log.info("Leszálltak");
			emptyable = true; // eddig false volt de csak akkor false ha volt előtte felszállás, de az nem itt állítódik :D
			//Meg kell keresni, hogy leszállás után, ki az első olyan nem üres kocsi, akiről
			//leszállhatnak majd
			boolean kov_emptyable = true; //false-ra állítjuk, ha meg van
			VonatElem kov = backElem;
			while(kov != null && kov_emptyable && kov.getColor() != "grey"){
				if(kov.getEmpty() == false){
					kov.setEmptyable(true);
					kov_emptyable = false;
				}
				kov = kov.backElem;
			}
		}
		/*Ez azért működik, mert ha le tudtak szállni, akkor előtte bíztosan mindenki üres
		 * tehát a következő kocsi-ra kell beállítanunk a emptyable-t, ami nem üres
		 */
		else {  // csak log miatt
			log.info("Nem szálltak le");
		}
		
		
	}

	public Sin getWhereAmI() {
		//log.info("VonatElem: getWhereAmI meghívva");
		
		/** Lekérdezzük az aktuális tartózkodási helyét */
		return whereAmI;
	}
	
	public void setWhereAmI(Sin elem) {
		//log.info("VonatElem: setWhereAmI meghívva");
		
		/** Beállítja az aktuális tartózkodási helyét */
		whereAmI = elem;
	}
	
	public void setFrontElem(VonatElem frontElem_) {
		//log.info("VonatElem: setFrontElem meghívva");
		
		/** Beállítja az előtte álló VonatElem-re mutató referenciát */
		frontElem = frontElem_;
	}
	
	public void setBackElem(Kocsi backElem_) {
		//log.info("VonatElem: setBackElem meghívva");
		
		/** Beállítja az mögötte álló VonatElem-re mutató referenciát */
		backElem = backElem_;
	}
	
	public String getColor() {
		//log.info("VonatElem: getColor meghívva");
		
		/** Visszaadja az adott Kocsi színét. */
		return color;
	}
	
	public boolean getEmpty() {
		//log.info("VonatElem: getEmpty meghívva");
		
		return empty;
	}
	
	public void setEmpty(boolean bool) {
		//log.info("VonatElem: setEmpty meghívva");
		
		empty = bool;
	}
	
	public boolean getEmptyable() {
		//log.info("VonatElem: getEmptyable meghívva");
		
		return emptyable;
	}
	
	public void setEmptyable(boolean bool) {
		//log.info("VonatElem: setEmptyable meghívva");
		
		emptyable = bool;
	}
}