package vasut;

import java.io.BufferedReader;
import java.util.List;

public class Valto extends Sin{

	public Valto(Sin aPoint_) {
		super(aPoint_);
	}
	
	public int getActState(){
		System.out.println("Az aktuális állapot: ");
		return 0;
		/** Lekérdezi az aktuális állapotot*/
	}
	
	public void nextState(){
		/** Megváltoztatja az állapotát*/
		System.out.println("Az állapot megváltozott.");
	}
	
	public void addConnectPoints(Sin a){
		System.out.println("Kapcsolódási pont hozzáadva.");
		/** Hozzáadja a kapcsolódási pontot a listához*/
	}
}
