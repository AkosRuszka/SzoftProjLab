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
	public static final Logger log = LogManager.getLogger(Palya.class);
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
	
	public boolean logCheck(){
		int goodRow = 0;
		
		try{
		FileInputStream fstream = new FileInputStream(".\\logs\\logigng.log");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		
		for (int i = 0; i < oup.size(); i++) {
			while ((strLine = br.readLine()) != null)   {
				if(strLine.contains(oup.get(i))){
					goodRow++;
					break;
				}					
			}
		}
		br.close();
		}
		
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		if(goodRow == oup.size())
			return true;
		else
			return false;
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
			case "compare":{
				int n1 = Integer.parseInt(line[1])-1;
				int n2 = Integer.parseInt(line[2])-1;
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
				log.info("teszthiba --- hibás bemenet");
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
				log.info("teszthiba --- hibás bemenet");
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
				int n1 = Integer.parseInt(line[1])-1;
				int n2 = Integer.parseInt(line[2])-1;
				rail.get(n1).setAPoint(rail.get(n2));
				break;
			}
			case "sin.setB":{
				int n1 = Integer.parseInt(line[1])-1;
				int n2 = Integer.parseInt(line[2])-1;
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
				log.info("teszthiba --- hibás bemenet");
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
						Sin s = new Sin(rail.get(Integer.parseInt(line[3])-1));
						rail.add(Integer.parseInt(line[2])-1,s);
					}
					else{
						Sin s = new Sin(null);
						rail.add(Integer.parseInt(line[2])-1,s);
					}
					break;
				}
				case "allomas" :{
					if (!rail.isEmpty()){
						String[] pass1 = null;
						for(int l = 5; l < line.length; l++){
							for(int o = 0; o < line.length; o++){
								pass1[o]=line[l];
							}
						}
						Allomas a = new Allomas(rail.get(Integer.parseInt(line[3])-1), line[4], pass1);
						rail.add(Integer.parseInt(line[2])-1,a);
					}
					else {
						String[] pass2 = null;
						for(int l = 5; l < line.length; l++){
							for(int o = 0; o < line.length; o++){
								pass2[o]=line[l];
							}
						}	
						Allomas a = new Allomas(null, line[4], pass2);
						rail.add(Integer.parseInt(line[2])-1,a);
					}
					break;
				}
				default:{
					log.info("teszthiba --- hibás bemenet");
				}
				}
			}
			case "put" :{
				switch(line[1]){
				case "mozdony" :{
					Mozdony m = new Mozdony(rail.get(Integer.parseInt(line[4])-1));
					train.add(Integer.parseInt(line[2])-1,m);
					engine.add(Integer.parseInt(line[2])-1,m);
				}
				case "kocsi" :{
					Kocsi k = new Kocsi(rail.get(Integer.parseInt(line[4])-1), train.get(Integer.parseInt(line[3])-1), line[5]);
					if (line[6].equals("-tele"))
						k.setEmpty(true);
					else
						k.setEmpty(false);
					train.add(Integer.parseInt(line[2])-1, k);
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
	
	public void teszt10111213(){
		Alagut a = new Alagut();
		ArrayList<KulonlegesHely> kh = new ArrayList<KulonlegesHely>();
		
		for(int i = 0; i < inp.size(); i++){
			String line[] = inp.get(i).split(" ");
			switch(line[0]){
				case "create":{
					if(line[1].equals("alagut"))
						a = new Alagut();
					else if(line[1].equals("kulonlegeshely") && line[3].equals("0") && line[4].equals("alagut")){
						Sin s = new Sin(null);
						kh.add(new KulonlegesHely(s, a));
					}
					break;
				}
				case "alagutEpit":
				case "alagutBont":
					kh.get(Integer.parseInt(line[1])-1).checkTunnels();
					break;				
			}
		}		
	}
	
	public void teszt14(){
		ArrayList<Sin> rails = new ArrayList<Sin>();
		ArrayList<Integer> states = new ArrayList<Integer>();
		for (int i = 0; i < inp.size(); i++) {
			String line[] = inp.get(i).split(" ");
			switch(line[0]){
			case "valto.init":{
				int n1 = Integer.parseInt(line[1])-1;
				if(n1<0)
					rails.add(new Valto(null));
				else
					rails.add(new Valto(rails.get(n1)));
				break;
			}
			case "sin.init":{
				int n1 = Integer.parseInt(line[1])-1;
				if(n1<0)
					rails.add(new Sin(null));
				else
					rails.add(new Sin(rails.get(n1)));
				break;
			}
			case "valto.add":{
				int n1 = Integer.parseInt(line[1])-1;
				int n2 = Integer.parseInt(line[2])-1;
				((Valto)(rails.get(n1))).addConnectPoints(rails.get(n2));
				break;
			}
			case "valto.nextState":{
				int n1 = Integer.parseInt(line[1])-1;
				((Valto)(rails.get(n1))).nextState();
				break;
			}
			case "valto.keepState":{
				int n1 = Integer.parseInt(line[1])-1;
				states.add(((Valto)(rails.get(n1))).getActState());
				break;
			}
			case "jatek.compare":{
				int n1 = Integer.parseInt(line[1])-1;
				int n2 = Integer.parseInt(line[2])-1;
				if(states.get(n1)==states.get(n2)){
					log.info("megegyezik a 2 pálya!");
				}
				else{
					log.info("nem egyezik meg a 2 pálya!");
				}
				break;
			}
			default:
				log.info("teszthiba --- hibás bemenet");
				break;
			}
		}
	}
	
	public void teszt15(){
		ArrayList<Sin> rails = new ArrayList<Sin>();
		ArrayList<VonatElem> trains = new ArrayList<VonatElem>();
		for (int i = 0; i < inp.size(); i++) {
			String line[] = inp.get(i).split(" ");
			switch(line[0]){
			case "allomas.init":{
				int n1 = Integer.parseInt(line[1])-1;
				String s[] = null;
				for (int j = 3; j < line.length; j++) {
					s[j-3] = line[j];
				}
				if(n1<0)
					rails.add(new Allomas(null,line[2],s));
				else
					rails.add(new Allomas(rails.get(n1),line[2],s));
				break;
			}
			case "sin.init":{
				int n1 = Integer.parseInt(line[1])-1;
				if(n1<0)
					rails.add(new Sin(null));
				else
					rails.add(new Sin(rails.get(n1)));
				break;
			}
			case "sin.setA":{
				int n1 = Integer.parseInt(line[1])-1;
				int n2 = Integer.parseInt(line[2])-1;
				rails.get(n1).setAPoint(rails.get(n2));
				break;
			}
			case "sin.setB":{
				int n1 = Integer.parseInt(line[1])-1;
				int n2 = Integer.parseInt(line[2])-1;
				rails.get(n1).setBPoint(rails.get(n2));
				break;
			}
			case "mozdony.init":{
				int n1 = Integer.parseInt(line[1])-1;
				trains.add(new Mozdony(rails.get(n1)));
				break;
			}
			case "kocsi.init":{
				int n1 = Integer.parseInt(line[1])-1;
				int n2 = Integer.parseInt(line[2])-1;
				if(n2<0)
					trains.add(new Kocsi(rails.get(n1),null,line[3]));
				else
					trains.add(new Kocsi(rails.get(n1),trains.get(n2),line[3]));
				break;
			}
			case "kocsi.setback":{
				int n1 = Integer.parseInt(line[1])-1;
				int n2 = Integer.parseInt(line[2])-1;
				trains.get(n1).setBackElem(((Kocsi)trains.get(n2)));
				break;
			}
			case "run":{
				int n1 = Integer.parseInt(line[1])-1;
				try {
					boolean t = ((Mozdony)trains.get(n1)).run();
					log.info(t);
				} catch (Exception e) {
					log.info("elkapott hiba: "+e.getMessage());
					e.printStackTrace();
				}
				break;
			}
			default:
				log.info("teszthiba --- hibás bemenet");
				break;
			}
		}
	}
	
	//futtatás
	public static void main(String[] args) throws Exception {
		
		Jatek j = new Jatek();
		j.makeGame();
		j.saveMap();
	}
}

class Bekeres {
	String valaszbekeres() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String valasz = br.readLine();
		return valasz;
	}
}