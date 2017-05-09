package vasut;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Random;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import graph.RailEvent;

public class Palya implements Serializable, Runnable{
	private static final Logger log = LogManager.getLogger(Palya.class);
	protected ArrayList<EventListener> list = new ArrayList<EventListener>();
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
	
	/** Listenerek felvétele */
	public void addActionListener(EventListener listener) {
		list.add(listener);
	}
	
	/** Buttonhoz eseményéhez kötött megszakítás. */
	public void quitToMain() throws Exception {
		synchronized (this){
			killed=true;
			//event----------------------------------
			RailEvent re = new RailEvent(this, 2, list.get(0));
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
						//event----------------------------------
						RailEvent re = new RailEvent(this, 3, list.get(0));
						re.fire();
						//endevent-------------------------------
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
				RailEvent re = new RailEvent(this, 1, list.get(0));
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
		}
		for (int i = 0; i < 2; i++) {
			mymap[1+i][8] = new Sin(mymap[0+i][8]);
		}
		mymap[3][8] = new Valto(mymap[2][8]);
		((Valto)mymap[3][8]).addConnectPoints(mymap[2][8]);
		mymap[3][7] = new Sin(mymap[3][8]);
		((Valto)mymap[3][8]).addConnectPoints(mymap[3][7]);
		for (int i = 0; i < 6; i++) {
			mymap[3][6-i] = new Sin(mymap[3][7-i]);
		}
		String[] s1 ={"Blue","Green","Green"};
		mymap[3][0] = new Allomas(mymap[3][1],"Red",s1);
		for (int i = 0; i < 11; i++) {
			mymap[4+i][0] = new Sin(mymap[3+i][0]);
		}
		for (int i = 0; i < 4; i++) {
			mymap[14][1+i] = new Sin(mymap[14][0+i]);
		}
		mymap[14][5] = new Valto(mymap[14][4]);
		((Valto)mymap[14][5]).addConnectPoints(mymap[14][4]);
		
		//a bal szélső különlegeshelytől 
		//a piros állomáson keresztül a az állomás utáni kereszteződésig
	}
	
	public void map3(){
		Sin mymap[][] = new Sin[30][30];
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				mymap[i][j] = null;
			}
		}
		Alagut a = new Alagut();
		
		mymap[28][9] = new Kezdopont(20, 50, 2, null);
		mymap[27][9] = new Sin(mymap[28][9]);
		mymap[28][9].setBPoint(mymap[27][9]);
		mymap[26][9] = new Sin(mymap[27][9]);
		mymap[27][9].setBPoint(mymap[26][9]);
		mymap[25][9] = new Sin(mymap[26][9]);
		mymap[26][9].setBPoint(mymap[25][9]);
		mymap[24][9] = new Allomas(mymap[25][9], "Yellow", null);
		mymap[25][9].setBPoint(mymap[24][9]);
		mymap[23][9] = new Sin(mymap[24][9]);
		mymap[24][9].setBPoint(mymap[23][9]);
		mymap[22][9] = new Sin(mymap[23][9]);	//sarok
		mymap[23][9].setBPoint(mymap[22][9]);
		mymap[22][8] = new Sin(mymap[22][9]);	
		mymap[22][9].setBPoint(mymap[22][8]);
		mymap[22][7] = new Sin(mymap[22][8]);
		mymap[22][8].setBPoint(mymap[22][7]);
		mymap[22][6] = new Sin(mymap[22][7]);
		mymap[22][7].setBPoint(mymap[22][6]);
		mymap[22][5] = new Valto(mymap[22][6]);
		mymap[22][6].setBPoint(mymap[22][5]);
		mymap[22][4] = new Sin(mymap[22][5]);
		mymap[22][5].setBPoint(mymap[22][4]);
		mymap[22][3] = new Sin(mymap[22][4]);
		mymap[22][4].setBPoint(mymap[22][3]);
		mymap[22][2] = new Sin(mymap[22][3]);	//sarok
		mymap[22][3].setBPoint(mymap[22][2]);
		for (int i = 21; i >= 9; i--){
			mymap[i][2] = new Sin(mymap[i+1][2]);
			mymap[i+1][2].setBPoint(mymap[i][2]);	//utolsó a sarok ELLENŐRIZNI INDEXEKET
		}
		mymap[9][3] = new Sin(mymap[9][2]);
		mymap[9][2].setBPoint(mymap[9][3]);
		mymap[9][4] = new Sin(mymap[9][3]);
		mymap[9][3].setBPoint(mymap[9][4]);
		mymap[9][5] = new Valto(mymap[9][4]);
		mymap[9][4].setBPoint(mymap[9][5]);
		mymap[8][5] = new Sin(mymap[9][5]);
		mymap[9][5].setBPoint(mymap[8][5]);
		mymap[7][5] = new Sin(mymap[8][5]);
		mymap[8][5].setBPoint(mymap[7][5]);
		mymap[6][5] = new Sin(mymap[7][5]);
		mymap[7][5].setBPoint(mymap[6][5]);
		mymap[5][5] = new Sin(mymap[6][5]);
		mymap[6][5].setBPoint(mymap[5][5]);
		mymap[4][5] = new KulonlegesHely(mymap[5][5], a);
		mymap[5][5].setBPoint(mymap[4][5]);
		////
		mymap[23][5] = new Sin(null);
		((Valto)mymap[22][5]).addConnectPoints(mymap[23][5]);
		mymap[24][5] = new Sin(mymap[23][5]);
		mymap[23][5].setBPoint(mymap[24][5]);
		mymap[25][5] = new Sin(mymap[24][5]);
		mymap[24][5].setBPoint(mymap[25][5]);
		mymap[26][5] = new Sin(mymap[25][5]);
		mymap[25][5].setBPoint(mymap[26][5]);
		mymap[27][5] = new Valto(mymap[26][5]);
		mymap[26][5].setBPoint(mymap[27][5]);
		mymap[27][6] = new Sin(mymap[27][5]);
		mymap[27][5].setBPoint(mymap[27][6]);
		////
		mymap[27][4] = new Sin(null);
		((Valto)mymap[27][5]).addConnectPoints(mymap[27][4]);
		mymap[27][3] = new Sin(mymap[27][4]);
		mymap[27][4].setBPoint(mymap[27][3]);
		mymap[27][2] = new KulonlegesHely(mymap[27][3], a);
		mymap[27][3].setBPoint(mymap[27][2]);
		////
		mymap[9][6] = new Sin(null);
		((Valto)mymap[9][5]).addConnectPoints(mymap[9][6]);
		mymap[9][7] = new Sin(mymap[9][6]);
		mymap[9][6].setBPoint(mymap[9][7]);
		mymap[9][8] = new Sin(mymap[9][7]);
		mymap[9][7].setBPoint(mymap[9][8]);
		mymap[9][9] = new Sin(mymap[9][8]);
		mymap[9][8].setBPoint(mymap[9][9]);
		mymap[9][10] = new Sin(mymap[9][9]);
		mymap[9][9].setBPoint(mymap[9][10]);
		mymap[9][11] = new Sin(mymap[9][10]);
		mymap[9][10].setBPoint(mymap[9][11]);
		mymap[9][12] = new Sin(mymap[9][11]);	//cross
		mymap[9][11].setBPoint(mymap[9][12]);
		mymap[9][13] = new Sin(mymap[9][12]);
		mymap[9][12].setBPoint(mymap[9][13]);
		mymap[9][14] = new Sin(mymap[9][13]);
		mymap[9][13].setBPoint(mymap[9][14]);
		mymap[9][15] = new Sin(mymap[9][14]);
		mymap[9][14].setBPoint(mymap[9][15]);
		mymap[9][16] = new Valto(mymap[9][15]);
		mymap[9][15].setBPoint(mymap[9][16]);
		mymap[8][16] = new Sin(mymap[9][16]);
		mymap[9][16].setBPoint(mymap[8][16]);
		mymap[7][16] = new Sin(mymap[8][16]);
		mymap[8][16].setBPoint(mymap[7][16]);
		mymap[6][16] = new Sin(mymap[7][16]);
		mymap[7][16].setBPoint(mymap[6][16]);
		mymap[5][16] = new Sin(mymap[6][16]);
		mymap[6][16].setBPoint(mymap[5][16]);
		mymap[4][16] = new Sin(mymap[5][16]);	//cross
		mymap[5][16].setBPoint(mymap[4][16]);
		mymap[3][16] = new Sin(mymap[4][16]);
		mymap[4][16].setBPoint(mymap[3][16]);
		mymap[2][16] = new Sin(mymap[3][16]);
		mymap[3][16].setBPoint(mymap[2][16]);
		mymap[1][16] = new Sin(mymap[2][16]);	//sarok
		mymap[2][16].setBPoint(mymap[1][16]);
		mymap[1][15] = new Sin(mymap[1][16]);
		mymap[1][16].setBPoint(mymap[1][15]);
		mymap[1][14] = new Sin(mymap[1][15]);
		mymap[1][15].setBPoint(mymap[1][14]);
		mymap[1][13] = new Sin(mymap[1][14]);
		mymap[1][14].setBPoint(mymap[1][13]);
		mymap[1][12] = new Sin(mymap[1][13]);
		mymap[1][13].setBPoint(mymap[1][12]);
		mymap[1][11] = new Allomas(mymap[1][12], "Green", null);
		mymap[1][12].setBPoint(mymap[1][11]);
		mymap[1][10] = new Sin(mymap[1][11]);
		mymap[1][11].setBPoint(mymap[1][10]);
		mymap[1][9] = new Sin(mymap[1][10]);
		mymap[1][10].setBPoint(mymap[1][9]);
		mymap[1][8] = new Sin(mymap[1][9]);
		mymap[1][9].setBPoint(mymap[1][8]);
		mymap[1][7] = new Sin(mymap[1][8]);
		mymap[1][8].setBPoint(mymap[1][7]);
		mymap[1][6] = new Sin(mymap[1][7]);
		mymap[1][7].setBPoint(mymap[1][6]);
		mymap[1][5] = new KulonlegesHely(mymap[1][6], a);
		mymap[1][6].setBPoint(mymap[1][5]);
		////
		mymap[9][17] = new Sin(null);
		((Valto)mymap[9][16]).addConnectPoints(mymap[9][17]);
		mymap[9][18] = new Sin(mymap[9][17]);
		mymap[9][17].setBPoint(mymap[9][18]);
		mymap[9][19] = new Sin(mymap[9][18]);
		mymap[9][18].setBPoint(mymap[9][19]);
		mymap[10][19] = new Sin(mymap[9][19]);
		mymap[9][19].setBPoint(mymap[10][19]);
		mymap[11][19] = new Sin(mymap[10][19]);
		mymap[10][19].setBPoint(mymap[11][19]);
		mymap[12][19] = new Sin(mymap[11][19]);
		mymap[11][19].setBPoint(mymap[12][19]);
		mymap[13][19] = new Valto(mymap[12][19]);
		mymap[12][19].setBPoint(mymap[13][19]);
		mymap[13][18] = new Sin(mymap[13][19]);
		mymap[13][19].setBPoint(mymap[13][18]);
		mymap[13][17] = new Sin(mymap[13][18]);
		mymap[13][18].setBPoint(mymap[13][17]);
		mymap[13][16] = new Sin(mymap[13][17]);
		mymap[13][17].setBPoint(mymap[13][16]);
		mymap[13][15] = new Allomas(mymap[13][16], "Blue", null);
		mymap[13][16].setBPoint(mymap[13][15]);
		mymap[13][14] = new Sin(mymap[13][15]);
		mymap[13][15].setBPoint(mymap[13][14]);
		mymap[13][13] = new Sin(mymap[13][14]);
		mymap[13][14].setBPoint(mymap[13][13]);
		mymap[13][13].setBPoint(null);
		////
		mymap[14][19] = new Sin(null);
		((Valto)mymap[13][19]).addConnectPoints(mymap[14][19]);
		mymap[15][19] = new Sin(mymap[14][19]);
		mymap[14][19].setBPoint(mymap[15][19]);
		mymap[16][19] = new Sin(mymap[15][19]);
		mymap[15][19].setBPoint(mymap[16][19]);
		mymap[17][19] = new Valto(mymap[16][19]);
		mymap[16][19].setBPoint(mymap[17][19]);
		mymap[17][20] = new Sin(mymap[17][19]);
		mymap[17][19].setBPoint(mymap[17][20]);
		mymap[17][21] = new Allomas(mymap[17][20], "Yellow", null);
		mymap[17][20].setBPoint(mymap[17][21]);
		mymap[17][22] = new Sin(mymap[17][21]);
		mymap[17][21].setBPoint(mymap[17][22]);
		mymap[17][23] = new Sin(mymap[17][22]);
		mymap[17][22].setBPoint(mymap[17][23]);
		mymap[17][23].setBPoint(null);
		////
		mymap[18][19] = new Sin(null);
		((Valto)mymap[17][19]).addConnectPoints(mymap[18][19]);
		mymap[19][19] = new Sin(mymap[18][19]);
		mymap[18][19].setBPoint(mymap[19][19]);
		mymap[20][19] = new Sin(mymap[19][19]);
		mymap[19][19].setBPoint(mymap[20][19]);
		mymap[21][19] = new Sin(mymap[20][19]);
		mymap[20][19].setBPoint(mymap[21][19]);
		mymap[22][19] = new Sin(mymap[21][19]);
		mymap[21][19].setBPoint(mymap[22][19]);
		mymap[23][19] = new Sin(mymap[22][19]);
		mymap[22][19].setBPoint(mymap[23][19]);
		mymap[24][19] = new Sin(mymap[23][19]);	//sarok
		mymap[23][19].setBPoint(mymap[24][19]);
		mymap[24][20] = new Sin(mymap[24][20]);
		mymap[24][19].setBPoint(mymap[24][19]);
		mymap[24][21] = new Valto(mymap[24][20]);
		mymap[24][20].setBPoint(mymap[24][21]);
		mymap[24][22] = new Sin(mymap[24][21]);
		mymap[24][21].setBPoint(mymap[24][22]);
		mymap[24][23] = new Sin(mymap[24][22]);
		mymap[24][22].setBPoint(mymap[24][23]);
		mymap[24][24] = new Sin(mymap[24][24]);	//sarok
		mymap[24][23].setBPoint(mymap[24][23]);
		mymap[23][24] = new Sin(mymap[24][24]);
		mymap[24][24].setBPoint(mymap[23][24]);
		mymap[22][24] = new Sin(mymap[23][24]);
		mymap[23][24].setBPoint(mymap[22][24]);
		mymap[21][24] = new Sin(mymap[22][24]);
		mymap[22][24].setBPoint(mymap[21][24]);
		mymap[20][24] = new Sin(mymap[21][24]);
		mymap[21][24].setBPoint(mymap[20][24]);
		mymap[19][24] = new Sin(mymap[20][24]);
		mymap[20][24].setBPoint(mymap[19][24]);
		mymap[18][24] = new Sin(mymap[19][24]);
		mymap[19][24].setBPoint(mymap[18][24]);
		mymap[17][24] = new Valto(mymap[18][24]);
		mymap[18][24].setBPoint(mymap[17][24]);
		((Valto)mymap[17][24]).addConnectPoints(mymap[17][23]);
		mymap[16][24] = new Sin(mymap[17][24]);
		mymap[17][24].setBPoint(mymap[16][24]);
		mymap[15][24] = new Sin(mymap[16][24]);
		mymap[16][24].setBPoint(mymap[15][24]);
		mymap[14][24] = new Sin(mymap[15][24]);
		mymap[15][24].setBPoint(mymap[14][24]);
		mymap[13][24] = new Sin(mymap[14][24]);
		mymap[14][24].setBPoint(mymap[13][24]);
		mymap[12][24] = new Sin(mymap[13][24]);
		mymap[13][24].setBPoint(mymap[12][24]);
		mymap[11][24] = new Valto(mymap[12][24]);
		mymap[12][24].setBPoint(mymap[11][24]);
		mymap[11][25] = new Sin(mymap[11][24]);
		mymap[11][24].setBPoint(mymap[11][25]);
		mymap[11][26] = new Sin(mymap[11][25]);
		mymap[11][25].setBPoint(mymap[11][26]);
		mymap[11][27] = new Sin(mymap[11][26]);
		mymap[11][26].setBPoint(mymap[11][27]);
		mymap[11][28] = new Sin(mymap[11][27]);	//sarok
		mymap[11][27].setBPoint(mymap[11][28]);
		mymap[12][28] = new Sin(mymap[11][28]);
		mymap[11][28].setBPoint(mymap[12][28]);
		mymap[13][28] = new Sin(mymap[12][28]);
		mymap[12][28].setBPoint(mymap[13][28]);
		mymap[14][28] = new Allomas(mymap[13][28], "Blue", null);
		mymap[13][28].setBPoint(mymap[14][28]);
		mymap[15][28] = new Sin(mymap[14][28]);
		mymap[14][28].setBPoint(mymap[15][28]);
		mymap[16][28] = new Sin(mymap[15][28]);
		mymap[15][28].setBPoint(mymap[16][28]);
		mymap[17][28] = new KulonlegesHely(mymap[16][28], a);
		mymap[16][28].setBPoint(mymap[17][28]);
		////
		mymap[25][21] = new Sin(null);
		((Valto)mymap[24][21]).addConnectPoints(mymap[25][21]);
		mymap[26][21] = new Sin(mymap[25][21]);
		mymap[25][21].setBPoint(mymap[26][21]);
		mymap[27][21] = new Sin(mymap[26][21]);	//sarok
		mymap[26][21].setBPoint(mymap[27][21]);
		mymap[27][20] = new Sin(mymap[27][21]);
		mymap[27][21].setBPoint(mymap[27][20]);
		mymap[27][19] = new Sin(mymap[27][20]);
		mymap[27][20].setBPoint(mymap[27][19]);
		mymap[27][18] = new Sin(mymap[27][19]);
		mymap[27][19].setBPoint(mymap[27][18]);
		mymap[27][17] = new Sin(mymap[27][18]);
		mymap[27][18].setBPoint(mymap[27][17]);
		mymap[27][16] = new Sin(mymap[27][17]);
		mymap[27][17].setBPoint(mymap[27][16]);
		mymap[27][15] = new Allomas(mymap[27][16], "Green", null);
		mymap[27][16].setBPoint(mymap[27][15]);
	}
	
	public ArrayList<Sin> getMap() {//ez a Viewnek kell a kirajzoláshoz
		return map;
	}

	public ArrayList<Mozdony> getEngines() {//ez is a Viewnek kell a kirajzoláshoz
		return engines;
	}

}