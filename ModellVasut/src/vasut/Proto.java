package vasut;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import vasut.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Proto {
	private static final Logger log = LogManager.getLogger(Palya.class);
	//tesztelés
	private ArrayList<String> inp = new ArrayList<String>(); 
	private ArrayList<String> oup = new ArrayList<String>(); 
	
	public void loadInput(int x){
		try{
			FileInputStream loadFile = null;
			
			switch (x) {
			case 1:
				loadFile = new FileInputStream("Init.txt");	            
				break;
			case 2:
				loadFile = new FileInputStream("Kezdopont_work.txt");	            
				break;
			case 3:
				loadFile = new FileInputStream("Start_mozgas.txt");	            
				break;
			case 4:
				loadFile = new FileInputStream("Allomas_athaladas_1.txt");	            
				break;
			case 5:
				loadFile = new FileInputStream("Allomas_athaladas_2.txt");	            
				break;
			case 6:
				loadFile = new FileInputStream("Allomas_athaladas_3.txt");	            
				break;
			case 7:
				loadFile = new FileInputStream("Allomas_athaladas_4.txt");	            
				break;
			case 8:
				loadFile = new FileInputStream("Utkozes.txt");	            
				break;
			case 9:
				loadFile = new FileInputStream("Kisiklas.txt");	            
				break;
			case 10:
				loadFile = new FileInputStream("Alagut_fel.txt");	            
				break;
			case 11:
				loadFile = new FileInputStream("Alagut_le.txt");	            
				break;
			case 12:
				loadFile = new FileInputStream("Alagut_teljes.txt");	            
				break;
			case 13:
				loadFile = new FileInputStream("Alagut_van.txt");	            
				break;
			case 14:
				loadFile = new FileInputStream("Valto.txt");	            
				break;
			case 15:
				loadFile = new FileInputStream("Jatek_vege.txt");	            
				break;
			}
			if(loadFile==null)
				throw new Exception("Nem megfelelő file!");
			
			InputStreamReader load = new InputStreamReader(loadFile);
			BufferedReader br = new BufferedReader(load);
			String line;
            while((line = br.readLine()) != null){
            	System.out.println(line);
            	inp.add(line);
            }
            load.close();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void loadOutput(int x){
		try{
			FileInputStream loadFile = null;
			
			switch (x) {
			case 1:
				loadFile = new FileInputStream("Init_out.txt");	            
				break;
			case 2:
				loadFile = new FileInputStream("Kezdopont_work_out.txt");	            
				break;
			case 3:
				loadFile = new FileInputStream("Start_mozgas_out.txt");	            
				break;
			case 4:
				loadFile = new FileInputStream("Allomas_athaladas_1_out.txt");	            
				break;
			case 5:
				loadFile = new FileInputStream("Allomas_athaladas_2_out.txt");	            
				break;
			case 6:
				loadFile = new FileInputStream("Allomas_athaladas_3_out.txt");	            
				break;
			case 7:
				loadFile = new FileInputStream("Allomas_athaladas_4_out.txt");	            
				break;
			case 8:
				loadFile = new FileInputStream("Utkozes_out.txt");	            
				break;
			case 9:
				loadFile = new FileInputStream("Kisiklas_out.txt");	            
				break;
			case 10:
				loadFile = new FileInputStream("Alagut_fel_out.txt");	            
				break;
			case 11:
				loadFile = new FileInputStream("Alagut_le_out.txt");	            
				break;
			case 12:
				loadFile = new FileInputStream("Alagut_teljes_out.txt");	            
				break;
			case 13:
				loadFile = new FileInputStream("Alagut_van_out.txt");	            
				break;
			case 14:
				loadFile = new FileInputStream("Valto_out.txt");	            
				break;
			case 15:
				loadFile = new FileInputStream("Jatek_vege_out.txt");	            
				break;
			}
			if(loadFile==null)
				throw new Exception("Nem megfelelő file!");
			
			InputStreamReader load = new InputStreamReader(loadFile);
			BufferedReader br = new BufferedReader(load);
			String line;
            while((line = br.readLine()) != null){
            	System.out.println(line);
            	oup.add(line);
            }
            load.close();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void teszt1(){
		ArrayList<Integer> maps = new ArrayList<Integer>();
		Jatek j1 = null;
		for (int i = 0; i < inp.size(); i++) {
			String line[] = inp.get(i).split(" ");
			switch(line[0]){
			case "jatek.init":{
				j1=new Jatek();
				break;
			}
			case "jatek.newgame":{
				j1.newGame();
				break;
			}
			case "jatek.savemap":{
				j1.saveMap();
				break;
			}
			case "jatek.loadmap":{
				j1.mapLoad();
				break;
			}
			case "jatek.compare":{
				int n1 = Integer.parseInt(line[1]);
				int n2 = Integer.parseInt(line[2]);
				if(maps.get(n1)==maps.get(n2)){
					log.info("megegyezik a 2 pálya!");
				}
				else{
					log.info("nem egyezik meg a 2 pálya!");
				}
				break;
			}
			case "keepmap":{
				maps.add(j1.getAM());
				break;
			}
			default:
				/// itt repül majd 1 hibaüzenet ;)
				break;
			}
		}
	}
	
	public void teszt2(){
		ArrayList<Kezdopont> rail = new ArrayList<Kezdopont>();
		Mozdony m = null;
		for (int i = 0; i < inp.size(); i++) {
			String line[] = inp.get(i).split(" ");
			switch(line[0]){
			case "kezdopont.init":{
				int n1 = Integer.parseInt(line[1]);
				int n2 = Integer.parseInt(line[2]);
				int n3 = Integer.parseInt(line[3]);
				rail.add(new Kezdopont(n1,n2,n3,null));
				break;
			}
			case "kezdopont.work":{
				m = rail.get(0).work();
				break;
			}
			default:
				/// itt repül majd 1 hibaüzenet ;)
				break;
			}
		}
	}
	
	public void teszt3(){
		ArrayList<Sin> rail = new ArrayList<Sin>();
		Mozdony m = null;
		for (int i = 0; i < inp.size(); i++) {
			String line[] = inp.get(i).split(" ");
			switch(line[0]){
			case "kezdopont.init":{
				int n1 = Integer.parseInt(line[1]);
				int n2 = Integer.parseInt(line[2]);
				int n3 = Integer.parseInt(line[3]);
				rail.add(new Kezdopont(n1,n2,n3,null));
				break;
			}
			case "kezdopont.work":{
				Kezdopont k = (Kezdopont)(rail.get(0));
				m = k.work();
				break;
			}
			case "sin.init":{
				rail.add(new Sin(null));
				break;
			}
			case "sin.setA":{
				int n1 = Integer.parseInt(line[1]);
				int n2 = Integer.parseInt(line[2]);
				rail.get(n1).setAPoint(rail.get(n2));
				break;
			}
			case "sin.setB":{
				int n1 = Integer.parseInt(line[1]);
				int n2 = Integer.parseInt(line[2]);
				rail.get(n1).setBPoint(rail.get(n2));
				break;
			}			
			case "mozdony.run":{
				try {
					m.run();
				} catch (Exception e) {
					log.info(e);
					e.printStackTrace();
				}
				break;
			}
			default:
				/// itt repül majd 1 hibaüzenet ;)
				break;
			}
		}
	}
	
	/**Allomas athaladas tesztek + ütközés + kisiklás
	 * @throws Exception */
	public void teszt456789() throws Exception{
		ArrayList<Sin> rail = new ArrayList<Sin>();
		ArrayList<VonatElem> train = new ArrayList<VonatElem>();
		ArrayList<Mozdony> engine = new ArrayList<Mozdony>();
		for (int i = 0; i < inp.size(); i++) {
			String line[] = inp.get(i).split(" ");
			switch(line[0]){
			case "create" :{
				switch(line[1]){
				case "sin" :{
					if (!rail.isEmpty()){
						Sin s = new Sin(rail.get(Integer.parseInt(line[3])));
						rail.add(Integer.parseInt(line[2]),s);
					}
					else{
						Sin s = new Sin(null);
						rail.add(Integer.parseInt(line[2]),s);
					}
					break;
				}
				case "allomas" :{
					if (!rail.isEmpty()){
						Allomas a = new Allomas(rail.get(Integer.parseInt(line[3])), line[4]);
						rail.add(Integer.parseInt(line[2]),a);
					}
					else {
						Allomas a = new Allomas(null, line[4]);
						rail.add(Integer.parseInt(line[2]),a);
					}
					break;
				}
				default:{
					//hiba
				}
				}
			}
			case "put" :{
				switch(line[1]){
				case "mozdony" :{
					Mozdony m = new Mozdony(rail.get(Integer.parseInt(line[4])));
					train.add(Integer.parseInt(line[2]),m);
					engine.add(Integer.parseInt(line[2]),m);
				}
				case "kocsi" :{
					Kocsi k = new Kocsi(rail.get(Integer.parseInt(line[4])), train.get(Integer.parseInt(line[3])), line[5]);
					if (line[6].equals("-tele"))
						k.setEmpty(true);
					else
						k.setEmpty(false);
					train.add(Integer.parseInt(line[2]), k);
				}
				default: {
					//hiba
				}
				}
			}
			case "run" :{
				for (int x = 0; x < engine.size(); x++){
					engine.get(x).run();
				}
			}
			default:{
				//hiba
			}
			}
		}
	}
	
	//futtatás
	public static void main(String[] args) throws Exception {
		
		Jatek j = new Jatek();
	}
}

class Bekeres {
	String valaszbekeres() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String valasz = br.readLine();
		return valasz;
	}
}