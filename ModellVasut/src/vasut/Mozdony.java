package vasut;

public class Mozdony extends VonatElem {
	
	public Mozdony(){};
	
	public boolean run() throws Exception {
		/** Elindul a mozdony és maga után húzza a kocsijait. */
		System.out.println("Megindul a vonat. Állomáson keresztül megy? (I/N): ");
		if(new Bekeres().valaszbekeres().equals("I"))
			new Allomas(null, "0").actMove();
		else 
			new Sin(null).actMove();
		
		System.out.println("Van előttem sín? (I/N): ");
		if(new Bekeres().valaszbekeres().equals("I")) {
			System.out.println("Továbbhaladunk, húzom a kocsim.");
			new Sin(null).setActVonatElem(null);
			new Sin(null).setActVonatElem(this);
			new Kocsi().pull();
			new Kocsi().getColor();
			System.out.println("Szürke az utolsó kocsi? (I/N): ");
			if(new Bekeres().valaszbekeres().equals("I"))
				return true;
			else
				return false;
		}
		else
			System.out.println("Kisiklottunk.");
		return false;
		
 			
	}
}
