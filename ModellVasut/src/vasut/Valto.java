	package vasut;

import java.util.List;

public class Valto extends Sin{

	public Valto(Sin aPoint_) {
		super(aPoint_);
	}
	
	public int getActState(){
		System.out.println("Lekérdeztük az aktuális állapotot.");
		return 0;
		/** Lekérdezi az aktuális állapotot*/
	}
	
	public void nextState(){
		System.out.println("Az állapot megváltozott. (1->2 / 2->3 / 3->1)");
		/** Megváltoztatja az állapotot*/
	}
	
	public void addConnectPoints(Sin a){
		System.out.println("Kapcsolódási pont hozzáadva.");
		/** Hozzáadja a kapcsolodósi pontot a listához*/
	}
}