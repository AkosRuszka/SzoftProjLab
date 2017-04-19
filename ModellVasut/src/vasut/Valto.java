package vasut;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Valto extends Sin{
	
	private static final Logger Log = LogManager.getLogger(Allomas.class);
	
	private int actState = 0;
	private ArrayList<Sin> connectPoints;

	public Valto(Sin aPoint_) {
		super(aPoint_);
		connectPoints = new ArrayList<Sin>();
	}
	
	public int getActState(){
		Log.info("Valto.getActState()");
		System.out.println("Valto.getActState()");
		return actState;
	}
	
	public void nextState(){
		Log.info("Valto.nextState()");
		System.out.println("Valto.nextState()");
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
		Log.info("Valto.addConnectPoints()");
		System.out.println("Valto.addConnectPoints()");
		connectPoints.add(a);
	}
}