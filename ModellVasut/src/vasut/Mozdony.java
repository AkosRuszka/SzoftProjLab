package vasut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Mozdony extends VonatElem {
	
	private static final Logger log = LogManager.getLogger(VonatElem.class);
	
	private Kocsi lastCart;
	
	public Mozdony(Sin whereAmI_){
		super(whereAmI_, null, "grey");
		lastCart = null;
		log.info("Mozdony konstruktora meghívva");
	}
	
	@Override
	public boolean getEmpty() {
		/* Azért kell hogy az utána következő kocsiról le tudjanak szállni */
		return true;
	}
	
	@Override
	public boolean getEmptyable() {
		/* Azért kell hogy az utána következő kocsiról le tudjanak szállni */
		return true;
	}
	
	public boolean run() throws Exception {
		log.info("Mozdony: run meghívva");
		/* Egyszeri lefutás 1. run-nál */
		if(lastCart == null){
			for (Kocsi k = this.backElem; k != null ; k = k.backElem)
				lastCart = k;
		}
		/* elmentjük az aktuálic elem által visszaadott sin referenciát */
		Sin idefogokmozogni = whereAmI.actMove();
		
		if (idefogokmozogni != null){
			// már megvan hogy merre mozoghatunk ezért nullázzuk az actuális által tárolt VonatElem-et (hisz lejövünk róla)
			whereAmI.setActVonatElem(null); 
			
			/* beállítjuk magunknak az következő sin referenciát*/
			whereAmI = idefogokmozogni;
			
			/* ne mutasson rá több referencia (nem tudom kell e) */
			idefogokmozogni = null;
			
			whereAmI.setActVonatElem(this);
			
			backElem.pull();
			
			if (lastCart.getEmpty() && lastCart.getEmptyable()){//üres és előtte üresekvannak
				return true;
			}
			else{
				return false;
			}
		}
		else{
			log.info("EXception: Kisiklott a vonat");
			throw new Exception("Kisiklott a vonat");
		} 			
	}
}
