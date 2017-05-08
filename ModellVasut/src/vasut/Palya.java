package vasut;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import graph.RailEvent;

public class Palya implements Serializable, Runnable{
	private static final Logger log = LogManager.getLogger(Palya.class);
	
	private boolean speed;
	private boolean done;
	private ArrayList<Sin> map;
	private Kezdopont startPoint;
	private ArrayList<Mozdony> engines;
	private Alagut tunnel;
	private boolean killed = false;
	
	public Palya(){
		map=new ArrayList<Sin>();
		engines = new ArrayList<Mozdony>();
		speed = false;
		done = false;
		tunnel = new Alagut();
		startPoint = new Kezdopont(1, 5, 1, null);
		map.add(startPoint);
	}
	
	/** Buttonhoz eseményéhez kötött megszakítás. */
	public void quitToMain() throws Exception {
		synchronized (this){
			killed=true;
			//event----------------------------------
			RailEvent re = new RailEvent(this, 2);
			re.fire();
			//endevent-------------------------------
			Thread.sleep(200);
			log.info("Exception dobva: quitToMain");
			throw new RuntimeException("quitToMain");
		}
	}
	
	/** A játék futása a megfelelő vizsgálatokkal. */
	public void run(){
		while(true){ 
			if(speed){
				//System.out.println("Game thread is doing stuff....."); 
				Mozdony uj = startPoint.work();
				try {
					if(uj != null) {
						engines.add(uj); 
					}
					done = true;// nullázzuk a done-t
					for (Mozdony mozdony : engines) {					
						done &= mozdony.run();
					}
				} catch (Exception e) {						
					e.printStackTrace();
					log.info("Hiba elkapva: "+e.getMessage());
					break;
				}
				//event----------------------------------
				RailEvent re = new RailEvent(this, 1);
				re.fire();
				//endevent-------------------------------
				try { 
					Thread.sleep(200); 
					} 
				catch (InterruptedException e) {
					log.info("Nem várt futási hiba elkapva: "+e.getMessage());
					e.printStackTrace(); 
					}
				if(killed||done){
					//System.out.println("Game thread is now stopped");
					break;
				}
			}
			else{
				synchronized (this){
					while(speed){
						//System.out.println("Game thread is paused");
						try {
							wait();
						} catch (InterruptedException e) {					
							e.printStackTrace();
							log.info("Nem várt várakozási hiba elkapva: "+e.getMessage());
						}
						if(killed||done){
							//System.out.println("Game thread is now stopped");
							break;
						}
					}
				}
			}
		}			
	}
	
	/** Megállítjuk illetve elindítjuk a játékot. */
	public void setStartStop() throws Exception{
		synchronized (this){
			if(speed) {
				speed = false;
			} else {
				speed = true;
				this.notifyAll();
			}
		}
	}

	public void map1(){
		Sin mymap[][] = new Sin[30][30];
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				mymap[i][j] = null;
			}
		}
		//25x29
		Alagut a = new Alagut();
		
		
		mymap[0][17] = new KulonlegesHely(null, a);
		for (int i = 0; i < 9; i++) {
			mymap[0][16-i] = new Sin(mymap[0][17-i]);
			mymap[0][17-i].setBPoint(mymap[0][16-i]);
		}
		for (int i = 0; i < 2; i++) {
			mymap[1+i][8] = new Sin(mymap[0+i][8]);
			mymap[0+i][8].setBPoint(mymap[1+i][8]);
		}
		mymap[3][8] = new Valto(mymap[2][8]);
		((Valto)mymap[3][8]).addConnectPoints(mymap[2][8]);
		mymap[3][7] = new Sin(mymap[3][8]);
		((Valto)mymap[3][8]).addConnectPoints(mymap[3][7]);
		for (int i = 0; i < 6; i++) {
			mymap[3][6-i] = new Sin(mymap[3][7-i]);
			mymap[3][7-i].setBPoint(mymap[3][6-i]);
		}
		String[] s1 ={"Blue","Green","Green"};
		mymap[3][0] = new Allomas(mymap[3][1],"Red",s1);
		for (int i = 0; i < 11; i++) {
			mymap[4+i][0] = new Sin(mymap[3+i][0]);
			mymap[3+i][0].setBPoint(mymap[4+i][0]);
		}
		for (int i = 0; i < 4; i++) {
			mymap[14][1+i] = new Sin(mymap[14][0+i]);
			mymap[14][0+i].setBPoint(mymap[14][1+i]);
		}
		mymap[14][5] = new Valto(mymap[14][4]);
		((Valto)mymap[14][5]).addConnectPoints(mymap[14][4]);
		
		//a bal szélső különlegeshelytől 
		//a piros állomáson keresztül a az állomás utáni kereszteződésig
	}
	
	public ArrayList<Sin> getMap() {//ez a Viewnek kell a kirajzoláshoz
		return map;
	}

	public ArrayList<Mozdony> getEngines() {//ez is a Viewnek kell a kirajzoláshoz
		return engines;
	}

}