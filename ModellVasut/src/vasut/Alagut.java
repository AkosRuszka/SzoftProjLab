package vasut;

public class Alagut {
	private List<Sin> tunnel = new List<Sin>();
	private KulonlegesHely exitA;
	private KulonlegesHely exitB;
	
	Alagut(){
		
	}
	
	public Sin build(KulonlegesHely hely){
		//felépíti a kapcsolatot a különleges hellyel
		System.out.println("build() metódus lefutott");
		return Sin;
		
	}
	
	public Sin destroy(KulonlegesHely hely){
		System.out.println("destroy() metódus lefutott");
		return Sin;
	}
	
	public void setExitA(KulonlegesHely a){
		System.out.println("setExitA() metódus lefutott");
	}
	
	public void setExitB(KulonlegesHely b){
		System.out.println("setExitB() metódus lefutott");
	}
}
