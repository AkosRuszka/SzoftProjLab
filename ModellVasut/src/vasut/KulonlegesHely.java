package vasut;
import java.io.IOException;

public class KulonlegesHely extends Sin{
	private Alagut aObserver;
	
	KulonlegesHely(Sin aPoint_, Alagut a){
		super(aPoint_);
		aObserver = a;
	}
	
	public void checkTunnels() throws IOException{ 
		//Megnézi, hogy van-e alagút felépítve már és ez alapján cselekszik
		/**Alagutat kell építeni, ha a vagy b pontja null, és az aObserver build metódusát, ennek függvényében meghívni
		   majd frissíteni a csatlakozási pont értékét */
		if(getAPoint() == null || getAPoint() == null){
			if(aPoint == null){
				setAPoint(aObserver.build(this));			
			}
			else if(bPoint == null){
				setBPoint(aObserver.build(this));
			}
		}		
		/** Ha nincs null érték, akkor viszont bontani kell az alagutat. 
		 *  Azt felét kell lebontani, ahol nem null érték van, ezt viszont az alagut elintézi
		 * */
		else{
			aObserver.destroy(this);
		}
	}
}