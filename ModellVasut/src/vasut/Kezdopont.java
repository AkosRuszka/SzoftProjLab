package vasut;

import java.io.IOException;
import java.util.*;
import vasut.*;

public class Kezdopont extends Sin{
	
	public Kezdopont(Sin aPoint_) {		
		super(aPoint_);
		System.out.println("Kezdopont létrejött");
		Sin sin1 = new Sin(this);
		this.setAPoint(sin1);
		Sin sin2 = new Sin(sin1);
		sin1.setBPoint(sin2);
		Sin sin3 = new Sin(sin2);
		sin2.setBPoint(sin3);
		Sin sin4 = new Sin(sin3);
		sin3.setBPoint(sin4);
		Sin sin5 = new Sin(sin4);
		sin4.setBPoint(sin5);
		Sin sin6 = new Sin(sin5);
		sin5.setBPoint(sin6);
		Sin sin7 = new Sin(sin6);
		sin6.setBPoint(sin7);
		Sin sin8 = new Sin(sin7);
		sin7.setBPoint(sin8);
		Sin sin9 = new Sin(sin8);
		sin8.setBPoint(sin9);
		Sin sin10 = new Sin(sin9);
		sin9.setBPoint(sin10);
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
		System.out.println("Jöjjön új vonat?	i/n");
		try {
			Bekeres b = new Bekeres();
			char c = b.valaszbekeres().toCharArray()[0];
			if(c=='i'){ // itt még ezer dolgot meg fog vizsgálni h mikor jöjjön vonat de majd csak a kész programban ;)
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