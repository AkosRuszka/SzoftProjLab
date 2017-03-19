package vasut;

import java.io.IOException;
import java.util.*;

public class Jatek {
	
	public void newGame(){
		System.out.println("Jatek.newGame()");
		//pálya 1
		Kezdopont kezd = new Kezdopont();
		Sin sin1 = new Sin();
		kezd.setBPoint(sin1);
		sin1.setAPoint(kezd);
		Sin sin2 = new Sin();
		sin1.setBPoint(sin2);
		sin2.setBPoint(sin1);
	}
	public void nextMap(){
		System.out.println("Jatek.nextMap()");
		//pálya 2
		Kezdopont kezd = new Kezdopont();
		Sin sin1 = new Sin();
		kezd.setBPoint(sin1);
		sin1.setAPoint(kezd);
		Valto sin2 = new Valto();
		sin1.setBPoint(sin2);
		sin2.setAPoint(sin1);
		sin2.addConnectPoints(sin1);
		
	}
	public void mapLoad(){
		System.out.println("Jatek.mapLoad()");
		System.out.println("Melyik Pályát töltsük be? 1/2");
		try {
			Bekeres b = new Bekeres();
			char c = b.valaszbekeres().toCharArray()[0];
			if(c=='1'){ // itt még ezer dolgot meg fog vizsgálni h mikor jöjjön vonat de majd csak a kész programban ;)
				Kezdopont kezd = new Kezdopont();
				Sin sin1 = new Sin();
				kezd.setBPoint(sin1);
				sin1.setAPoint(kezd);
				Sin sin2 = new Sin();
				sin1.setBPoint(sin2);
				sin2.setBPoint(sin1);
			}
			else{
				Kezdopont kezd = new Kezdopont();
				Sin sin1 = new Sin();
				kezd.setBPoint(sin1);
				sin1.setAPoint(kezd);
				Valto sin2 = new Valto();
				sin1.setBPoint(sin2);
				sin2.setAPoint(sin1);
				sin2.addConnectPoints(sin1);
			}
		}
		catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
}