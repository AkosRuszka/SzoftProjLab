package vasut;

import java.io.IOException;

public class Kocsi extends VonatElem {
	
	public Kocsi(){};
	
	public void changeColor() {
		/** Beállítja a kocsi színét szürkére, az előtte álló kocsi színétől függően. */
		System.out.println("Meghívódott a színváltás függvényem. Szürke az előttem álló kocsi?");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) 
				System.out.println("Megváltozott a színem szürkére.");
			else
				System.out.println("Nem változott semmi");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void pull() {
		/** A mozdony hívja meg az osztálynak ezt a függvényét ha a kocsinak át kell mennie a következő sínre. A sínek segítségével pedig arrébb tudd mozogni a megfelelő irányba. */
		System.out.println("Elhúzott egy vonatelem. Van mögöttem másik kocsi?");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				System.out.println("Elhúzom őt is.");
 				new Kocsi().pull();
			}
			else
				System.out.println("Én voltam az utolsó kocsi, a mozgás befejeződött.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
