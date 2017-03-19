package vasut;

import java.io.IOException;
import java.util.*;
import vasut.*;

public class Kezdopont extends Sin{
	
	public Kezdopont(Sin aPoint_) {		
		super(aPoint_);
		System.out.println("Kezdopont l�trej�tt");
		//be�ll�todnak az attrib�tumok
		//elk�sz�k a "spawnTunnel"
	}
	
	public void spawnTrain(){
		System.out.println("Kezdopont.spawnTrain()");
		System.out.println("H�ny kocsija legyen a vonatnak?");
		Bekeres b = new Bekeres();
		int i = 0;
		try {
			i = (int)b.valaszbekeres().toCharArray()[0];
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		System.out.println("L�trej�tt a vonat "+i+" darab kocsival");
	}
	
	public VonatElem work(){
		System.out.println("Kezdopont.work()");
		System.out.println("J�jj�n �j vonat?	i/n");
		try {
			Bekeres b = new Bekeres();
			char c = b.valaszbekeres().toCharArray()[0];
			if(c=='i'){ // itt m�g ezer dolgot meg fog vizsg�lni h mikor j�jj�n vonat de majd csak a k�sz programban ;)
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
