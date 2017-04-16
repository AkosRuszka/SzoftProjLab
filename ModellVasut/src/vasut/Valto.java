package vasut;

import java.util.List;

public class Valto extends Sin{
	
	private int actState = 0;
	private List<Sin> connectPoints;

	public Valto(Sin aPoint_) {
		super(aPoint_);
	}
	
	public int getActState(){
		System.out.println("Valto.getActState()");
		return actState;
	}
	
	public void nextState(){
		System.out.println("Valto.nextState())");
		switch(actState){ // Ide kéne valami okos algoritmus a kapcsolódó sínek átállításához
		// Jelenlegi módszer: feltesszük, hogy a váltó A pont bPoint-ja, B és C pont aPointja.
		case 0: // A-ból B-be -> B-ből C-be
			connectPoints.get(0).setBPoint(null);
			connectPoints.get(2).setAPoint(this);
			
			aPoint = connectPoints.get(1);
			bPoint = connectPoints.get(2);
			actState++;
			break;
		case 1: // B-ből C-be -> C-ből A-ba
			connectPoints.get(1).setAPoint(null);
			connectPoints.get(0).setBPoint(this);
			
			aPoint = connectPoints.get(2);
			bPoint = connectPoints.get(0);
			actState++;
			break;
		case 2: // C-ből A-ba -> A-ból B-be
			connectPoints.get(2).setAPoint(null);
			connectPoints.get(1).setAPoint(this);
			
			aPoint = connectPoints.get(0);
			bPoint = connectPoints.get(1);
			actState = 0;
			break;
		}
	}
	
	public void addConnectPoints(Sin a){
		System.out.println("Valto.addConnectPoints()");
		connectPoints.add(a);
	}
}