package vasut;

import java.util.ArrayList;
import java.util.List;

public class Allomas extends Sin{
	private String color;
	private List<String> risers;
	
	public Allomas(Sin aPoint_ , String color_){
		super(aPoint_);
		risers = new ArrayList<String>();
		color = color_;
	}
	
	/** Visszaadjuk a színt */
	public String getColor() {
		//System.out.println("Állomás színének lekérdezése.");
		return color;
	}
	
	@Override
	public Sin actMove() throws Exception {
		//System.out.println("Állomás: actMove() függvény meghívva.");
		
		
		/** Csak akkor történik leszállás a vagonokról ha nem történik rá felszállás */
		if(risers.isEmpty() != true) {
			/** Ha az actVonatElem színe és a felszálló utasok színe egyezik akkor felszállnak rá */
			if(actVonatElem.getColor().equals(risers.get(0))) {
				risers.remove(0); 	// kiszedjük a tömbből azokat akik felszálltak a vonatra
				Get_on(); 			// franc se tudja ez mi....
			} else {
				/** Ha a risers tömbünk nem üres és a felszállandó emberek nem egyeznek meg az actVonatElem-el, attól még 
				 *  az actVonatElem-ről le lehet szállni. */
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
	
	/** ???? */
	public void Get_on() {
		/** Az actVonatElem empty attributumát beállítjuk true-ra ezzel jelezve hogy felszálltak rá. */
		actVonatElem.setEmpty(true);
		
		/* Ez biztos hogy az Állomás felelőssége ? 
		actVonatElem.setGet_on(true);
		*/
	}
}