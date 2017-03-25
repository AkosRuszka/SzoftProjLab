package vasut;
import java.util.ArrayList;

public class Alagut {
	private ArrayList<Sin> tunnel;  // Sin rendszer
	private KulonlegesHely exitA;	//Egyik kivezetés
	private KulonlegesHely exitB;	//Másik kivezetés
		
	Alagut(){
		//Alagut rendszer felépítése, ami fixen 10 elemű sínrendszerből áll
		tunnel = new ArrayList<Sin>(10);
		
		//Láncolt lista felépítése
		Sin elozo = new Sin(null);
		for(int i = 0; i < tunnel.size(); i++){
			Sin s = new Sin(elozo);
			tunnel.add(s);
			elozo = s;
		}
	}
	
	public Sin build(KulonlegesHely hely){
		//Felépíti a kapcsolatot a különleges hellyel, arra ponjára ami még üres
		if(exitA == null){
			this.setExitA(hely);
			tunnel.get(0).setAPoint(exitA);
			return tunnel.get(0);
		}
		else if(exitB == null){
			this.setExitB(hely);
			tunnel.get(tunnel.size()-1).setBPoint(exitB);
			return tunnel.get(tunnel.size()-1);
		}
		else
			return null;
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
}