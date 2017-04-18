package vasut;

import java.awt.Button;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.JFileChooser;
import vasut.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Jatek {
	private static final Logger log = LogManager.getLogger(Palya.class);
	
	private Palya actGame;	//a Játék tartalmazhat egy pályát
	private int actMap;		//aktuális pálya
	private String sugo;	//a Sugó szövege
	
	public Jatek(){
		actGame = null;
		actMap = 0;
		sugo = "Ez csak egy minta, ennél valószínűleg több és hasznosabb info lesz leírva de ez nem az én feladatom lol. :D \n ps: ha ez marad bent akkor bocsánat!";
	}
	
	public int getAM(){
		return actMap;
	}
	
	public Palya getGame(){
		return actGame;
	}
	
	public void newGame(){
		System.out.println("Jatek.newGame()");
		//pálya 1		
		try {
			FileInputStream loadFile = new FileInputStream("map1.dat");
            ObjectInputStream load = new ObjectInputStream(loadFile);
            actGame = (Palya) load.readObject();
            load.close();
			actMap = 1;
			
			//new Palya().run();
		} catch (Exception e) {
			log.info("Hiba elkapva: "+e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	public void nextMap(){
		System.out.println("Jatek.nextMap()");
		//pálya 2	
		try {
			FileInputStream loadFile = new FileInputStream("map"+(actMap+1)+".dat");
            ObjectInputStream load = new ObjectInputStream(loadFile);
            actGame = (Palya) load.readObject();
            load.close();
			actMap++;
			
			//new Palya().run();
		} catch (Exception e) {
			log.info("Hiba elkapva: "+e.getMessage());
			System.out.println(e.getMessage());
		}	
	}
	
	public void mapLoad(){
		System.out.println("Jatek.mapLoad()");		
		try {
			JFileChooser jfc = new JFileChooser();
			jfc.setCurrentDirectory(new File("."));
			jfc.setDialogTitle("Choose a map");
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			if(jfc.showOpenDialog(new Button()) == JFileChooser.APPROVE_OPTION){
				
			}
			if(!jfc.getSelectedFile().getName().contains("dat"))
				throw new IOException("Nem megfelelő fájltípus!");
			
			actMap = 0;
			for (int i = 1; i < 20; i++) {
				String name = "map"+(char)('0'+i);
				if(jfc.getSelectedFile().getName().contains(name)){
					FileInputStream loadFile = new FileInputStream(jfc.getSelectedFile());
		            ObjectInputStream load = new ObjectInputStream(loadFile);
		            actGame = (Palya) load.readObject();
		            load.close();
					actMap = i;
					break;
				}
			}
			if(actMap==0)
				throw new IOException("Nem megfelelő fájlnév!");
			
			//new Palya().run();
		}
		catch (Exception e){
			log.info("Hiba elkapva: "+e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	public void saveMap(){
		
		JFileChooser sfc = new JFileChooser();
	    sfc.setCurrentDirectory(new File("."));
	    if (sfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileOutputStream saveFile = new FileOutputStream(sfc.getSelectedFile());
	            ObjectOutputStream save = new ObjectOutputStream(saveFile);
	            save.writeObject(actGame);
	            save.close();
	        } catch (Exception e) {
	        	log.info("Hiba elkapva: "+e.getMessage());
	        	System.out.println(e.getMessage());
	        }
	    }	
		
	}
}