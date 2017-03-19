package vasut;

import java.util.*;

public class Jatek {
	
	public void newGame(){
		System.out.println("Jatek.newGame()");
		//pálya 1
		Kezdopont kezd = new Kezdopont(null);
		Sin sin1 = new Sin(kezd);
		kezd.setBPoint(sin1);
		Sin sin2 = new Sin(sin1);
		sin1.setBPoint(sin2);
		Allomas sin3 = new Allomas(sin2,"Blue");
		sin2.setBPoint(sin3);
		Sin sin4 = new Sin(sin3);
		sin3.setBPoint(sin4);
		Valto sin5 = new Valto(sin4);
		sin5.addConnectPoints(sin4);
		sin4.setBPoint(sin5);
		Sin sin6 = new Sin(sin5);
		sin5.setBPoint(sin6);
		sin5.addConnectPoints(sin6);
		Sin sin7 = new Sin(sin6);
		sin6.setBPoint(sin7);
		KulonlegesHely sin8 = new KulonlegesHely(sin7);
		
		sin7.setBPoint(sin8);		 
		Sin sin9 = new Sin(sin5);
		sin5.addConnectPoints(sin9);
		KulonlegesHely sin10 = new KulonlegesHely(sin9);
		sin9.setBPoint(sin10);
		System.out.println("Pálya elkészült");
	}
	public void nextMap(){
		System.out.println("Jatek.nextMap()");
		//pálya 2
		Kezdopont kezd = new Kezdopont(null);
		Sin sin1 = new Sin(kezd);
		kezd.setBPoint(sin1);
		Sin sin2 = new Sin(sin1);
		sin1.setBPoint(sin2);
		Allomas sin3 = new Allomas(sin2,"Blue");
		sin2.setBPoint(sin3);
		Sin sin4 = new Sin(sin3);
		sin3.setBPoint(sin4);
		Valto sin5 = new Valto(sin4);
		sin5.addConnectPoints(sin4);
		sin4.setBPoint(sin5);
		Sin sin6 = new Sin(sin5);
		sin5.setBPoint(sin6);
		sin5.addConnectPoints(sin6);
		Sin sin7 = new Sin(sin6);
		sin6.setBPoint(sin7);
		Allomas sin8 = new Allomas(sin7,"Red");
		sin7.setBPoint(sin8);
		Sin sin9 = new Sin(sin8);
		sin8.setBPoint(sin9);
		KulonlegesHely sin10 = new KulonlegesHely(sin9);
		
		Sin sin11 = new Sin(null);
		sin5.addConnectPoints(sin9);
		Sin sin12 = new Sin(sin11);
		sin11.setBPoint(sin12);
		Valto sin13 = new Valto(sin12);
		sin13.addConnectPoints(sin12);
		sin12.setBPoint(sin13);
		Sin sin14 = new Sin(sin13);
		sin13.setBPoint(sin14);
		sin13.addConnectPoints(sin14);
		KulonlegesHely sin15 = new KulonlegesHely(sin4);
		
		Sin sin16 = new Sin(null);
		sin13.addConnectPoints(sin16);
		Sin sin17 = new Sin(sin16);
		sin16.setBPoint(sin17);
		KulonlegesHely sin18 = new KulonlegesHely(sin17);
		sin17.setBPoint(sin18);
		System.out.println("Pálya elkészült");
	}
	public void mapLoad(){
		System.out.println("Jatek.mapLoad()");
	}
}