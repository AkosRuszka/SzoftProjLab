package vasut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Kocsi extends VonatElem{
	
	//Logoláshoz
	private static final Logger log = LogManager.getLogger(VonatElem.class);
	
	public Kocsi(Sin whereAmI_, VonatElem frontElem_, String color_){
		super(whereAmI_, frontElem_, color_);
		log.info("Kocsi konstruktora meghívva");
	}
	
	public void pull() throws Exception {
		log.info("Kocsi: pull meghívva");
		
		/** A mozdony hívja meg az osztálynak ezt a függvényét ha a kocsinak át kell mennie a következő sínre. 
		 * A sínek segítségével pedig arrébb tudd mozogni a megfelelő irányba. **/
		
		Sin idefogokmozogni = whereAmI.actMove();
		
		whereAmI.setActVonatElem(null);
		
		whereAmI = idefogokmozogni;
		
		idefogokmozogni = null;
		
		whereAmI.setActVonatElem(this);
		if(backElem != null)
			backElem.pull();
	}
	
	/* Ezt csak az állomás fogja meghívni és mindig csak a felszálláskor hívja meg tehát
	 * az aa paraméter false lesz 
	 */
	@Override
	public void setEmpty(boolean aa) {
		log.info("Kocsi: setEmpty meghívva");
		/* Ekvivalens azzal hogy empty = false; */ 
		empty = aa; 
		/* Jelezni kell a mögöttem állónak hogy nem szállhatnak le róla mivel rám felszálltak. */
		if(backElem != null) {
			log.info("backElem != null tehát továbbhívom rá a setEmptyable-t");
			backElem.setEmptyable(aa);
		}
		
		/* Event jelzés */
		for(ActionListener act : list) {
			act.actionPerformed(new ActionEvent(this,7,"KOCSI_NOTEMPTY"));
		}
	}
	
//	@Override
//	public void setEmpty(boolean b){
//		log.info("Kocsi: setEmpty meghívva");
//		
//		if(!b){
//			if(!empty){
//				empty = false; //Erre a kocsira felszállás történt
//				//Az emptyable sorrendet tisztáznunk kell
//				//Meg nézzük, hogy hány üres kocsi van előtte
//				int elottem_hany_ures = 0;
//				VonatElem elozo = frontElem;
//				while(elozo != null && elozo.getColor() != "grey"){
//					if(elozo.getEmpty() == false)
//						elottem_hany_ures++;
//					elozo = elozo.frontElem;
//				}
//				//Ha előtte nem üres mindenki az az nem 0 darab üres kocsi van előtte, akkor ő nem lehet emptyable
//				if(elottem_hany_ures != 0){
//					emptyable = false; 
//					/*Ide el kell képzelni egy rekurziót, megkeresi azt a kocsit aki elől van és nem üres
//					 * Még hozzá úgy, hogy tudjuk, hogy az aktuális kocsi előtt hány darab nem üres van
//					 * lefutattjuk azt a ciklust ennyiszer, ami elmegy a következő nem üres kocsiig
//					 * így a végén megkapjuk az első nem üres kocsit
//					 */
//					VonatElem elozo2 = frontElem;
//					for(int i = 0; i < elottem_hany_ures; i++){
//						boolean elotte_ures = true;
//						while(elozo2 != null && elozo2.getColor() != "grey" && elotte_ures){
//							if(elozo2.getEmpty() == false)
//								elotte_ures = false;
//							elozo2 = elozo2.frontElem;
//						}
//					}
//					//a ciklus végén meg van, hogy ki az az első üres kocsi, akiről leszállhatnak
//					//azért a backElem, mert az előző ciklusban mindig először lépteti a változót és csak utána nézi a feltétel teljesülését
//					elozo2.backElem.setEmptyable(true);
//				}
//				//Ha viszont előtte már mindenki üres, akkor ő lesz az emptyable -> az az kocsi, akiről leszállhatnak
//				else
//					emptyable = true;	
//			}
//		}
//		else
//			empty = b;
//	}
}
