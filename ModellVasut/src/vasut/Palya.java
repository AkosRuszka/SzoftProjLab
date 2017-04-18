package vasut;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.rmi.server.Operation;
import java.util.ArrayList;
import java.util.Random;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
	}
	
	/** Buttonhoz eseményéhez kötött megszakítás. */
	public void quitToMain() throws Exception {
		synchronized (this){
			killed=true;
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
					for (Mozdony mozdony : engines) {					
						done &= mozdony.run();
					}
				} catch (Exception e) {						
					e.printStackTrace();
					log.info("Hiba elkapva: "+e.getMessage());
					break;
				}
				
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

}