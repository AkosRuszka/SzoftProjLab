package vasut;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.rmi.server.Operation;
import java.util.ArrayList;
import java.util.Random;

public class Palya implements Serializable{
	private ArrayList<Sin> map;
	private Kezdopont startPoint;
	private ArrayList<Mozdony> engines;
	private boolean speed;
	private boolean done;
	private Alagut tunnel;
	
	public Palya(){
		map=new ArrayList<Sin>();
		//startPoint = new Kezdopont(5,6,2);
		engines = new ArrayList<Mozdony>();
		speed = false;
		done = false;
		//tunnel = new Alagut();
	}
	
	public void makeMap(int length){//átmeneti függvény, csinál egy tesztpályát		
		Sin seged = new Sin();
		seged.setAPoint(null);
		seged.setBPoint(null);
		map.add(seged);
		for (int i = 0; i < length; i++) {
			Sin seged2 = new Sin();
			seged2.setAPoint(map.get(i));
			seged2.setBPoint(null);
			map.get(i).setBPoint(seged);
			map.add(seged2);
		}
	}
	
	public void quitToMain(){
		System.out.println("Palya.quitToMain()");
	}
	
	public void run() throws Exception{
		System.out.println("Palya.run()");
		startPoint.work();
		new Mozdony(null,null,null).run();// <------------- ez még itt nem lesz jó csak kellett h ne legyen hiba XDD
		System.out.println("Palya: Minden kocsi színe szürke volt? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				System.out.println("Palya: Pálya teljesítve.");
				new Jatek().nextMap();
			} else {
				System.out.println("Palya: Megy tovább a játék.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Palya: Megállítod a játékot? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				setStartStop();
				System.out.println("Palya: Megállítottad a játékot. Elndítod? (I/N): ");
				try {
					if(new Bekeres().valaszbekeres().equals("I")) {
						setStartStop();
					} else {
						System.out.println("Palya: Nem történt semmi.");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Palya: Nem történt semmi.");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setStartStop(){
		System.out.println("Palya.setStartStop()");
	}

}