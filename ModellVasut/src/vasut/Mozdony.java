package vasut;

public class Mozdony extends VonatElem {
	
	private Kocsi lastCart;
	
	public Mozdony(Sin whereAmI_, VonatElem frontElem_, VonatElem backElem_, String color_){
		super(whereAmI_, frontElem_, backElem_, color_);
		if(backElem != null){
			Kocsi temp = new Kocsi(whereAmI_, frontElem_, backElem_, color_);
			while(temp.getBackElem() != null){							//Végigmegyünk az összes kocsin és 
				temp.setWhereAmI(temp.getBackElem().getWhereAmI());		//az utolsót beállítjuk a lastCart-nak
			}
			lastCart = temp;
		}
		else{
			lastCart = null;
		}
	}
	
	public boolean run() throws Exception {
		whereAmI = whereAmI.actMove();
		if (whereAmI != null){
			backElem.pull();
		}
		else{
			throw new Exception("Kisiklott a vonat");
		}
		
		
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