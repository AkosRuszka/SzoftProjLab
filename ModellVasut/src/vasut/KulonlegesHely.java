package vasut;
import java.io.IOException;
import java.io.Serializable;
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
		}		
		/** Ha nincs null érték, akkor viszont bontani kell az alagutat. 
		 *  Azt felét kell lebontani, ahol nem null érték van, ezt viszont az alagut elintézi
		 * */
		else{
			aObserver.destroy(this);
			log.info("KulonlegesHely: az Alagut bejárata lebontódott");
		}
	}
}