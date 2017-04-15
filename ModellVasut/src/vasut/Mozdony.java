package vasut;

public class Mozdony extends VonatElem {
	
	private Kocsi lastCart;
	
	public Mozdony(Sin whereAmI_, VonatElem frontElem_, Kocsi backElem_){
		super(whereAmI_, frontElem_, backElem_, "szurke");
		lastCart = null;
	}
	
	public boolean run() throws Exception {
		/** Elindul a mozdony és maga után húzza a kocsijait. */
		whereAmI = whereAmI.actMove();
		if (whereAmI != null){
			backElem.pull();
			if (lastCart.getColor().equals("szurke")){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			throw new Exception("Kisiklott a vonat");
		} 			
	}
}