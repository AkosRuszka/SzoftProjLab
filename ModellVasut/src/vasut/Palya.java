package vasut;

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
	
	public void run(){
		System.out.println("A vonaatok elindultak.");
		/**elind�tjuk �s mozgatjuk az �sszes vonatot*/
	}
	
	public void setStartStop(){
		System.out.println("START-r�l STOP-ra, vagy STOP-r�l START-ra v�ltozott az �llapot.");
		/**kapcsol a start �s stop �llapot k�z�tt*/
	}

}
