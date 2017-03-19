package vasut;

public class Mozdony extends VonatElem {
	
	public Mozdony(){};
	
	public boolean run() throws Exception {
		/** Elindul a mozdony és maga után húzza a kocsijait. */
		System.out.println("Mozdony: Megindul a vonat. Állomáson keresztül megy? (I/N): ");
		if(new Bekeres().valaszbekeres().equals("I"))
			new Allomas().actMove();
		else 
			new Sin().actMove();
		
		System.out.println("Van előttem sín? (I/N): ");
		if(new Bekeres().valaszbekeres().equals("I")) {
			System.out.println("Mozdony: Továbbhaladunk, húzom a kocsim.");
			new Sin().setActVonatElem(null);
			new Sin().setActVonatElem(this);
			new Kocsi().pull();
			new Kocsi().getColor();
			System.out.println("Mozdony: Szürke az utolsó kocsi? (I/N): ");
			if(new Bekeres().valaszbekeres().equals("I"))
				return true;
			else
				return false;
		}
		else {
			System.out.println("Mozdony: Kisiklottunk.");
			throw new Exception("Játék vége kisiklás miatt.");
		}
		
 			
	}
}