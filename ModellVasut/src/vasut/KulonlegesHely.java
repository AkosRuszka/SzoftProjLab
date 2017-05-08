package vasut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.*;

public class KulonlegesHely extends Sin implements Serializable{
	private Alagut aObserver; //A pályához tartozó alagut referenciája
	
	//Logoláshoz a logger osztály egy példánya
	private static final Logger log = LogManager.getLogger(Alagut.class);
	
	KulonlegesHely(Sin aPoint_, Alagut a){		
		super(aPoint_);
		aObserver = a;
		
		//Loglás
		log.info("A KulonlegesHely konstruktora meghívva");
	}
	
	//Listenerek felvétele
	public void addActionListener(ActionListener listener) {
		list.add(listener);
	}
	
	public void checkTunnels(){ 
		//Megnézi, hogy van-e alagút felépítve már és ez alapján cselekszik
		
		/**Alagutat kell építeni, ha a vagy b pontja null, és az aObserver build metódusát, ennek függvényében meghívni
		   majd frissíteni a csatlakozási pont értékét */
		if(getAPoint() == null || getBPoint() == null){
			if(aPoint == null){
				setAPoint(aObserver.build(this));				
				log.info("KulonlegesHely: aPoint-jához hozzákapcsolódott az Alagut");
			}
			else if(bPoint == null){
				setBPoint(aObserver.build(this));
				log.info("KulonlegesHely: bPoint-jához hozzákapcsolódott az Alagut");
			}
			
			/* Event jelzés */
			for(ActionListener act : list) {
				act.actionPerformed(new ActionEvent(this,3,"KH_TUNNEL_BUILD"));
			}
		}		
		/** Ha nincs null érték, akkor viszont bontani kell az alagutat. 
		 *  Azt felét kell lebontani, ahol nem null érték van, ezt viszont az alagut elintézi
		 * */
		else{
			aObserver.destroy(this);
			
			/* Event jelzés */
			for(ActionListener act : list) {
				act.actionPerformed(new ActionEvent(this,4	,"KH_TUNNEL_DESTROY"));
			}
			
			log.info("KulonlegesHely: az Alagut bejárata lebontódott");
		}
	}
}