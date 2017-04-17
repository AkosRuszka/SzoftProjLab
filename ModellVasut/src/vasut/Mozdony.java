package vasut;

public class Mozdony extends VonatElem {
	
	private Kocsi lastCart;
	
	public Mozdony(Sin whereAmI_, VonatElem frontElem_, Kocsi backElem_){
		super(whereAmI_, frontElem_, backElem_, "grey");
		lastCart = null;
	}
	
	public boolean run() throws Exception {
		/** Elindul a mozdony és maga után húzza a kocsijait. */
		whereAmI.setActVonatElem(null);
		whereAmI = whereAmI.actMove();
		if (whereAmI != null){
			whereAmI.setActVonatElem(this);
			backElem.pull();
			if (lastCart.getColor().equals("grey")){
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