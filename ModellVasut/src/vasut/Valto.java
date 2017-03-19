	package vasut;

import java.util.List;

public class Valto extends Sin{

	public Valto(Sin aPoint_) {
		super(aPoint_);
	}
	
	public int getActState(){
		System.out.println("Lek�rdezt�k az aktu�lis �llapotot.");
		return 0;
		/** Lek�rdezi az aktu�lis �llapotot*/
	}
	
	public void nextState(){
		System.out.println("Az �llapot megv�ltozott. (1->2 / 2->3 / 3->1)");
		/** Megv�ltoztatja az �llapot�t*/
	}
	
	public void addConnectPoints(Sin a){
		System.out.println("Kapcsol�d�si pont hozz�adva.");
		/** Hozz�adja a kapcsol�d�si pontot a list�hoz*/
	}
}
