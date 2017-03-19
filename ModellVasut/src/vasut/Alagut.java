package vasut;

import java.util.ArrayList;

public class Alagut {
	public ArrayList<Sin> tunnel = new ArrayList<Sin>();
	private KulonlegesHely exitA;
	private KulonlegesHely exitB;
	
	Alagut(){
		
	}
	
	public Sin build(KulonlegesHely hely){
		//felépíti a kapcsolatot a különleges hellyel
		System.out.println("Az alagút build() metódusa lefutott");
		return new Sin(null);
		
	}
	
	public Sin destroy(KulonlegesHely hely){
		System.out.println("Az alagút destroy() metódusa lefutott");
		return new Sin (null);
	}
	
	public void setExitA(KulonlegesHely a){
		System.out.println("Az alagút setExitA() metódusa lefutott");
	}
	
	public void setExitB(KulonlegesHely b){
		System.out.println("Az alagút setExitB() metódusa lefutott");
	}
}
