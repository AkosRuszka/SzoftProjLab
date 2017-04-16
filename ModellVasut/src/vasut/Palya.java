package vasut;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.rmi.server.Operation;
import java.util.ArrayList;
import java.util.Random;

public class Palya implements Serializable{
	private boolean speed;
	private boolean done;
	private ArrayList<Sin> map;
	private Kezdopont startPoint;
	private ArrayList<Mozdony> engines;
	private Alagut tunnel;
	
	public Palya(){
		map=new ArrayList<Sin>();
		//startPoint = new Kezdopont(5,6,2);
		engines = new ArrayList<Mozdony>();
		speed = false;
		done = false;
		tunnel = new Alagut();
	}
	
	/** Buttonhoz eseményéhez kötött megszakítás. */
	public void quitToMain() throws Exception {
		throw new RuntimeException("quitToMain");
	}
	
	/** A játék futása a megfelelő vizsgálatokkal. */
	public void run() throws Exception{		
		while(!done) {
			while(speed) {
				Mozdony uj = startPoint.work();
				if(uj != null) {
					engines.add(uj); 
				}
				for (Mozdony mozdony : engines) {
					done &= mozdony.run();
				}
			}
		}
		
	}
	
	/** Megállítjuk illetve elindítjuk a játékot. */
	public void setStartStop() throws Exception{
		if(speed) {
			speed = false;
		} else {
			speed = true;
			//run(); lehet ez nem is kell...
		}
	}

}