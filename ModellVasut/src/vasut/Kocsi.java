package vasut;

import java.io.IOException;

public class Kocsi extends VonatElem {
	
	public Kocsi(){};
	
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
