package vasut;

public class Kocsi extends VonatElem {
	
	public Kocsi(){};
	
	public void pull() throws Exception {
		/** A mozdony hívja meg az osztálynak ezt a függvényét ha a kocsinak át kell mennie a következő sínre. A sínek segítségével pedig arrébb tudd mozogni a megfelelő irányba. */
		System.out.println("Elhúzott egy vonatelem. Állomáson keresztül megyek? (I/N): ");
		if(new Bekeres().valaszbekeres().equals("I"))
			new Allomas(null, "0").actMove();
		else 
			new Sin(null).actMove();
		new Sin(null).setActVonatElem(null);
		new Sin(null).setActVonatElem(this);
		
		System.out.println("Van mögöttem másik kocsi? (I/N): ");
		if(new Bekeres().valaszbekeres().equals("I")) {
			System.out.println("Elhúzom őt is.");
 			new Kocsi().pull();
		}
		else
			System.out.println("Én voltam az utolsó kocsi, a mozgás befejeződött.");
	}
}
