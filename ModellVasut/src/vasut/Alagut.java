package vasut;
import java.io.Serializable;
import java.util.ArrayList;
import org.apache.log4j.*;

public class Alagut implements Serializable{
	//Osztály tagváltozói:
	private ArrayList<Sin> tunnel;  // Sin rendszer
	private KulonlegesHely exitA;	//Egyik kivezetés
	private KulonlegesHely exitB;	//Másik kivezetés
	
	//Logoláshoz a logger osztály egy példánya
	private static final Logger log = LogManager.getLogger(Alagut.class);
		
	Alagut(){
		log.info("Alagut konstruktor meghívva");
		//Alagut rendszer felépítése, ami fixen 10 elemű sínrendszerből áll
		tunnel = new ArrayList<Sin>(10);
		
		//Láncolt lista felépítése
		Sin elozo = new Sin(null);
		for(int i = 0; i < 10; i++){
			Sin s = new Sin(elozo);
			tunnel.add(s);
			elozo = s;
		}
	}
	
	public Sin build(KulonlegesHely hely){
		//Felépíti a kapcsolatot a különleges hellyel, arra ponjára ami még üres
		if(exitA == null){
			//Logolás
			log.info("Alagut: exitA helyre KulonlegesHely bekötve");
			
			this.setExitA(hely);
			tunnel.get(0).setAPoint(exitA);
			return tunnel.get(0);
		}
		else if(exitB == null){
			//Logolás
			log.info("Alagut: exitB helyre KulonlegesHely bekötve");
			
			this.setExitB(hely);
			tunnel.get(tunnel.size()-1).setBPoint(exitB);
			return tunnel.get(tunnel.size()-1);
		}
		else{
			log.info("Alagut: az Alagut már be van kötve");
			return null;
		}
	}
	
	public Sin destroy(KulonlegesHely hely){
		//Lebontja a kapcsoltatot a különleges hellyel, arról a pontról ahová kapcsolódott az adott KulonlegesHely
		//Plusz a különleges hely megfelelő pontát is beállítja, hogy ott null érték legyen
		if(exitA == hely){
			if(tunnel.get(0) == hely.getAPoint()){
				hely.setAPoint(null);
			}
			else{
				hely.setBPoint(null);				
			}
			tunnel.get(0).setAPoint(null);
			setExitA(null);
			
			//Logolás
			log.info("Alagut: exitA helyről a KulonlgesHely lebontva");
		}
		else if(exitB == hely){
			if(tunnel.get(tunnel.size()-1) == hely.getAPoint()){
				hely.setAPoint(null);
			}
			else{
				hely.setBPoint(null);
			}
			tunnel.get(tunnel.size()-1).setBPoint(null);
			setExitB(null);
			
			//Logolás
			log.info("Alagut: exitB helyről a KulonlgesHely lebontva");
		}		
		return null;
	}
	
	public void setExitA(KulonlegesHely a){
		//Beállítja az A ponjára a paraméterében kapott különleges helyet
		exitA = a;
	}
	
	public void setExitB(KulonlegesHely b){
		//Beállítja a B pontjára a paraméterben kapott különleges helyet
		exitB = b;
	}
	
	public String getType(){
		return "Alagut";
	}
}