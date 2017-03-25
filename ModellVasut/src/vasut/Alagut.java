package vasut;
import java.util.ArrayList;

public class Alagut {
	private ArrayList<Sin> tunnel;
	private KulonlegesHely exitA;
	private KulonlegesHely exitB;	
		
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
		//felépíti a kapcsolatot a különleges hellyel, arra ponjára ami még üres
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
		
		//Alagut sínrendszerének bekötözése, ha az eleje üres akkor az elejére, ha a vége akkor a végére
		//Első alkalommal biztosan az elejéhez fűzi
		/*if(tunnel.get(0).getAPoint() == null){
			tunnel.get(0).setAPoint(hely);
			return tunnel.get(0);
		}
		else{
			tunnel.get(tunnel.size()-1).setBPoint(hely);
			return tunnel.get(tunnel.size()-1);
		}*/
	}
	
	public Sin destroy(KulonlegesHely hely){
		//lebontja a kapcsoltatot a különleges hellyel, arról a pontról ahová kapcsolódott az adott KulonlegesHely
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
		
		//Sinrendszer beállítása, ki kell nullázni a különleges hely megfelelő pontját és az alagút megfeleő helyét
		/*if(tunnel.get(0) == hely.getAPoint()){
			hely.setAPoint(null);
			tunnel.get(0).setAPoint(null);
		}
		else if(tunnel.get(tunnel.size()-1) == hely.getAPoint()){
			hely.setAPoint(null);
			tunnel.get(tunnel.size()-1).setBPoint(null);
		}
		else if(tunnel.get(0) == hely.getBPoint()){
			hely.setBPoint(null);
			tunnel.get(0).setAPoint(null);
		}
		else{
			hely.setBPoint(null);
			tunnel.get(tunnel.size()-1).setBPoint(null);
		}*/
		
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