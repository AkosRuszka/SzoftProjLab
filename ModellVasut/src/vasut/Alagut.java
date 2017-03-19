package vasut;
import java.util.ArrayList;

public class Alagut {
	public ArrayList<Sin> tunnel = new ArrayList<Sin>(); //Az alagút sínei
	private KulonlegesHely exitA; //Egyik ki/bejárata
	private KulonlegesHely exitB; //Másik ki/bejárata
	
	Alagut(){}
	
	public Sin build(KulonlegesHely hely){
		//felépíti a kapcsolatot a különleges hellyel
		System.out.println("Az alagút build() metódusa lefutott");
		return new Sin(null);
		
	}
	
	public Sin destroy(KulonlegesHely hely){
		//lebontja a kapcsoltatot a különleges hellyel
		System.out.println("Az alagút destroy() metódusa lefutott");
		return new Sin (null);
	}
	
	public void setExitA(KulonlegesHely a){
		//Beállítja az A ponjára a paraméterében kapott különleges helyet
		System.out.println("Az alagút setExitA() metódusa lefutott");
	}
	
	public void setExitB(KulonlegesHely b){
		//Beállítja a B ponjára a paraméterében kapott különleges helyet
		System.out.println("Az alagút setExitB() metódusa lefutott");
	}
}
