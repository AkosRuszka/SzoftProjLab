package vasut;

public class Kocsi extends VonatElem {
	
	public Kocsi(Sin whereAmI_, VonatElem frontElem_, Kocsi backElem_, String color_){
		super(whereAmI_, frontElem_, backElem_, color_);
	}
	
	public void pull() throws Exception {
		/** A mozdony hívja meg az osztálynak ezt a függvényét ha a kocsinak át kell mennie a következő sínre. A sínek segítségével pedig arrébb tudd mozogni a megfelelő irányba. */
		
		
		System.out.println("Kocsi: Elhúzott egy vonatelem. Állomáson keresztül megyek? (I/N): ");
		if(new Bekeres().valaszbekeres().equals("I"))
			new Allomas().actMove();
		else 
			new Sin().actMove();
		new Sin().setActVonatElem(null);
		new Sin().setActVonatElem(this);
		
		System.out.println("Kocsi: Van mögöttem másik kocsi? (I/N): ");
		if(new Bekeres().valaszbekeres().equals("I")) {
			System.out.println("Kocsi: Elhúzom őt is!");
 			new Kocsi().pull();
		}
		else
			System.out.println("Kocsi: Én voltam az utolsó kocsi, a mozgás befejeződött.");
	}
}