package vasut;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Allomas extends Sin{
	
	private static final Logger Log = LogManager.getLogger(Allomas.class);
	
	private String color;
	private List<String> risers;
	
	public Allomas(Sin aPoint_ , String color_, String pass[]){
		super(aPoint_);
		
		Log.info("Állomás konstruktor meghívva.");
		
		risers = new ArrayList<String>();
		if(pass.length != 0){
			for (int i = 0; i < pass.length; i++) {
				risers.add(pass[i]);
			}
		}
		color = color_;
	}
	
	/** Visszaadjuk a színt */
	public String getColor() {
		return color;
	}
	
	@Override
	public Sin actMove() throws Exception {
		
		Log.info("actMove() meghívva.");		
		
		/** Csak akkor történik leszállás a vagonokról ha nem történik rá felszállás */
		if(risers.isEmpty() != true) {
			/** Ha az actVonatElem színe és a felszálló utasok színe egyezik akkor felszállnak rá */
			if(actVonatElem.getColor().equals(risers.get(0))) {
				risers.remove(0); 	// kiszedjük a tömbből azokat akik felszálltak a vonatra
				Get_on(); 			// Meghívjuk rá a felszállás függvényét
			} else {
				/** Ha a risers tömbünk nem üres és a felszállandó emberek nem egyeznek meg az actVonatElem-el, attól még 
				 *  az actVonatElem-ről le lehet szállni. */
				Log.info("Nem szálltak fel");
				if(actVonatElem.getColor().equals(color)) {
					actVonatElem.changeColor();
				}	
			}
		} else {
			/** Ha a risers üres, akkor biztos történhet (más feltételektől is függően) leszállás */
			if(actVonatElem.getColor().equals(color)) {
				actVonatElem.changeColor();
			}
		}
		return super.actMove();
	}
	
	/** Az adott kocsira felszállnak, ez meghívja a setEmpty függvényt, ami a Kocsi osztályban felül van írva, egy különleges vizsgálattal */
	public void Get_on() {
		Log.info("Get_on() meghívva");
		Log.info("Felszálltak");
		/** Az actVonatElem empty attributumát beállítjuk false-ra ezzel jelezve hogy felszálltak rá. */
		actVonatElem.setEmpty(false);
	}
}