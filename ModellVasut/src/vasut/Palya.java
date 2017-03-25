package vasut;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Palya {
	private ArrayList<Sin> map;
	private Sin startPoint;
	private ArrayList<Mozdony> engines;
	private boolean speed;
	private boolean done;
	private Alagut tunnel;
	
	public Palya(){
		
	}
	
	public void quitToMain(){
		System.out.println("Palya.quitToMain()");
	}
	
	public void mapSave(InputStream in){
		//Szerializálós magic függvény
		System.out.println("Palya.mapSave()");
	}
	
	public void run() throws Exception{
		System.out.println("Palya.run()");
		new Kezdopont().work();
		new Mozdony().run();
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