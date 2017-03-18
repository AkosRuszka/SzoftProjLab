package vasut;

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
	
	public void run(){
		System.out.println("A vonaatok elindultak.");
		/**elindítjuk és mozgatjuk az összes vonatot*/
	}
	
	public void setStartStop(){
		System.out.println("START-ról STOP-ra, vagy STOP-ról START-ra változott az állapot.");
		/**kapcsol a start és stop állapot között*/
	}

}
