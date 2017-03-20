package vasut;
import java.io.IOException;

public class KulonlegesHely extends Sin{
	
	KulonlegesHely(){
	}
	
	public void checkTunnels() throws IOException{ //Megnézi, hogy van-e alagút felépítve már és ez alapján cselekszik
		System.out.println("chechTunnel() metódus");
		System.out.println("Tartozik már hozzá alagút?");
		if(new Bekeres().valaszbekeres().equals("I")){
			new Alagut().destroy(null);
			setBPoint(null);
		}
		
		System.out.println("Fel van építve máshol alagút ? (I/N):");
		if(new Bekeres().valaszbekeres().equals("N")){
			new Alagut().destroy(null);
			new Alagut().setExitA(null);
			setBPoint(null);
		}
	}
}