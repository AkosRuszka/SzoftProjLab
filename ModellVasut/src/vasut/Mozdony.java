package vasut;

public class Mozdony extends VonatElem {
	
	private Kocsi lastCart;
	
	public Mozdony(Sin whereAmI_){
		super(whereAmI_, null, null, "grey");
		lastCart = null;
	}
	
	public boolean run() throws Exception {
		if(lastCart == null){
			for (Kocsi k = this.backElem; k != null ; k = k.backElem)
				lastCart = k;
		}
		
		Sin idefogokmozogni = whereAmI.actMove();
		//whereAmI = whereAmI.actMove();
		
		if (idefogokmozogni != null){
			// már megvan hogy merre mozoghatunk ezért nullázzuk az actuális által tárolt VonatElem-et (hisz lejövünk róla)
			whereAmI.setActVonatElem(null); 
			
			whereAmI = idefogokmozogni;
			whereAmI.setActVonatElem(this);
			
			backElem.pull();
			if (backElem.getEmpty()&&backElem.getEmptyable()){//üres és előtte üresekvannak
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
