package vasut;
import java.io.IOException;

public class KulonlegesHely extends Sin{
	private Alagut aObserver;
	
	KulonlegesHely(Sin aPoint_, Alagut a){
		super(aPoint_);
		aObserver = a;
	}
	
	//Ki kell majd törölni!!! - syntax error
	KulonlegesHely(){
		
	}
	
	public void checkTunnels() throws IOException{ //Megnézi, hogy van-e alagút felépítve már és ez alapján cselekszik
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
		 *  Azt felét kell lebontani, ahol nem null érték van
		 * */
		else{
			aObserver.destroy(this);
		}

		/*
		System.out.println("Különlegeshely: chechTunnel() metódus");
		System.out.println("Különlegeshely: tartozik már hozzá alagút? (I/N): ");
		if(new Bekeres().valaszbekeres().equals("I")){
			new Alagut().destroy(null);
			setBPoint(null);
		} 
		else {
			System.out.println("Fel van építve máshol alagút ? (I/N):");
			if(new Bekeres().valaszbekeres().equals("N")){
				new Alagut().build(null);
				new Alagut().setExitA(null);
				setBPoint(null);
			}
		}*/
	}
}