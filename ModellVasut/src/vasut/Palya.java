package vasut;

import java.io.IOException;
import java.io.InputStream;

public class Palya {
	
	public Palya(){
		
	}
	
	public void quitToMain(){
		System.out.println("Visszaléptünk a menübe.");
		
		/**visszalépünk a menübe*/
	}
	
	public void mapSave(InputStream in){
		System.out.println("Pálya mentve.");
		/**elmenti az adott pályát a paraméterben kapott file-ba*/
	}
	
	public void run() throws Exception{
		System.out.println("A vonatokat elindítottuk.");
		new Kezdopont(null).work();
		new Mozdony().run();
		System.out.println("Minden vonat tovább tudott haladni? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				System.out.println("Mehet tovább a játék.");
			} else {
				System.out.println("Játék vége.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Megállítod a játkot? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				setStartStop();
			} else {
				System.out.println("Nem történt semmi.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**elindítjuk és mozgatjuk az összes vonatot*/
	}
	
	public void setStartStop(){
		System.out.println("START-ról STOP-ra, vagy STOP-ról START-ra változott az állapot.");
		/**kapcsol a start és stop állapot között*/
	}

}