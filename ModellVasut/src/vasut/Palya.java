package vasut;

import java.io.IOException;
import java.io.InputStream;

public class Palya {
	
	public Palya(){
		
	}
	
	public void quitToMain(){
		System.out.println("Visszal�pt�nk a men�be.");
		
		/**visszal�p�nk a men�be*/
	}
	
	public void mapSave(InputStream in){
		System.out.println("P�lya mentve.");
		/**elmenti az adott p�ly�t a param�terben kapott file-ba*/
	}
	
	public void run() throws Exception{
		System.out.println("A vonatokat elind�tottuk.");
		new Kezdopont(null).work();
		new Mozdony().run();
		System.out.println("Minden vonat tov�bb tudott haladni? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				System.out.println("Mehet tov�bb a j�t�k.");
			} else {
				System.out.println("J�t�k v�ge.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Meg�ll�tod a j�tkot? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				setStartStop();
			} else {
				System.out.println("Nem t�rt�nt semmi.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**elind�tjuk �s mozgatjuk az �sszes vonatot*/
	}
	
	public void setStartStop(){
		System.out.println("START-r�l STOP-ra, vagy STOP-r�l START-ra v�ltozott az �llapot.");
		/**kapcsol a start �s stop �llapot k�z�tt*/
	}

}
