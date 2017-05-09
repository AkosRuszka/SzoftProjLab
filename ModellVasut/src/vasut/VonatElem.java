package vasut;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.*;

public class VonatElem implements Serializable{
	protected Sin whereAmI;
	protected VonatElem frontElem;
	protected Kocsi backElem;
	protected String color;
	protected boolean empty = false;
	protected boolean emptyable = false;
	
	//Rá feliratkozott ActionListenerek
	protected List<ActionListener> list;
	
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
		
		/* Ha előttem Mozdony van, akkor rólam leszállhatnak már a legelején. */
		if(frontElem != null) {
			if(frontElem.getEmpty()) {
				emptyable = true;
			} 
		}
		
		list = new ArrayList<ActionListener>();
		log.info("VonatElem konstruktora meghívva");
	}
	
	//Listenerek felvétele
	public void addActionListener(ActionListener listener) {
		list.add(listener);
	}
	
	/* Leszállhatnak rólad jelzés. */
	public void changeColor() {
		log.info("VonatElem: changeColor meghívva");
		/* Ha van is ki leszálljon rólam.... */
		if(!empty) {
			log.info("empty = false");
			/* Ha az előttem álló üres. */
			if(frontElem.getEmpty()) {
				log.info("előttem álló üres");
				/* Ha leszállhatnak rólam. */
				if(emptyable) {
					log.info("emptyable = true");
					log.info("Leszálltak");
					
					/* Direkt nem a setEmpty-t használva. (az felszálláshoz kell)*/
					empty = true;
					/* A mögöttem levő elemekről is leszállhatnak. */
					if(backElem != null) {
						backElem.setEmptyable(true);
					}
				} else {
					/* Csak a log miatt */
					log.info("emptyable = false");
					log.info("Nem szálltak le");
				}
			}
		}
	}
	
//	public void changeColor() { //Az állomás leszálláskor hívja ezt a függvényt
//		//Log
//		log.info("VonatElem: changeColor meghívva");
//		if(emptyable||frontElem.getColor()=="grey"){
//			empty = true;
//			log.info("Leszálltak");
//			emptyable = true; // eddig false volt de csak akkor false ha volt előtte felszállás, de az nem itt állítódik :D
//			//Meg kell keresni, hogy leszállás után, ki az első olyan nem üres kocsi, akiről
//			//leszállhatnak majd
//			boolean kov_emptyable = true; //false-ra állítjuk, ha meg van
//			VonatElem kov = backElem;
//			while(kov != null && kov_emptyable && kov.getColor() != "grey"){
//				if(kov.getEmpty() == false){
//					kov.setEmptyable(true);
//					kov_emptyable = false;
//				}
//				kov = kov.backElem;
//			}
//		}
//		/*Ez azért működik, mert ha le tudtak szállni, akkor előtte bíztosan mindenki üres
//		 * tehát a következő kocsi-ra kell beállítanunk a emptyable-t, ami nem üres
//		 */
//		else {  // csak log miatt
//			log.info("Nem szálltak le");
//		}
//		
//		
//	}
	public VonatElem getBackElem(){
		return backElem;
	}
	
	public VonatElem getBFrontElem(){
		return frontElem;
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
	
	//A tesztekhez való beállítás
	public void setEmptyFromTest(boolean em){
		log.info("Kocsi: setEmptyFromTest meghívva");
		empty = em;
	}
	
	public boolean getEmpty() {
		return empty;
	}
	
	public void setEmpty(boolean bool) {
		/* kb sose lesz meghívva */
		empty = bool;
	}
	
	public boolean getEmptyable() {	
		return emptyable;
	}
	
//	public void setEmptyable(boolean bool) {
//		//log.info("VonatElem: setEmptyable meghívva");
//		
//		emptyable = bool;
//	}
	
	/* Leszállhatnak/nem szállhatnak le rólad beállítása */
	public void setEmptyable(boolean aa) {
		log.info("setEmptyable meghivva");
		emptyable = aa;
		/* Ha üres vagyok akkor tovább kell hívnom az utánam levőre ezt. */
		if(empty) {
			log.info("üres vagyok ezért megnézzük hogy tovább adhatom e a jelzést");
			if(backElem != null) {
				log.info("backelem-re setemptyable továbbhívva");
				backElem.setEmptyable(aa);
			}
			log.info("nem vagyok üres ezért nem adom tovább a jelzést");
		}
	}
	public
	String getType(){
		return "VonatElem";
	}
}