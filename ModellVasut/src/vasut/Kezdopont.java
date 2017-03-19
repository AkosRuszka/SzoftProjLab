package vasut;

import java.io.IOException;
import java.util.*;
import vasut.*;

public class Kezdopont extends Sin{
	
	public Kezdopont() {
		//beállítodnak az attribútumok
		//elkészük a "spawnTunnel"
	}
	
	public void spawnTrain(){
		System.out.println("Kezdopont.spawnTrain()");
		System.out.println("Hány kocsija legyen a vonatnak?");
		Bekeres b = new Bekeres();
		int i = 0;
		try {
			i = (int)b.valaszbekeres().toCharArray()[0];
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		System.out.println("Létrejött a vonat "+i+" darab kocsival");
	}
	
	public VonatElem work(){
		System.out.println("Kezdopont.work()");
		System.out.println("Jöjjön új vonat?	(I/N)");
		try {
			Bekeres b = new Bekeres();
			char c = (b.valaszbekeres().toUpperCase()).toCharArray()[0];
			if(c=='I'){ // itt még ezer dolgot meg fog vizsgálni h mikor jöjjön vonat de majd csak a kész programban ;)
				spawnTrain();
				return null;
			}					
		}
		catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
}