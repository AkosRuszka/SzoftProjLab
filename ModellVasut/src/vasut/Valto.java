package vasut;

import java.io.BufferedReader;
import java.util.List;

public class Valto extends Sin{

	public Valto(Sin aPoint_) {
		super(aPoint_);
	}
	
	public int getActState(){
		System.out.println("Az aktu�lis �llapot: ");
		return 0;
		/** Lek�rdezi az aktu�lis �llapotot*/
	}
	
	public void nextState(){
		/** Megv�ltoztatja az �llapot�t*/
		System.out.println("Az �llapot megv�ltozott.");
	}
	
	public void addConnectPoints(Sin a){
		System.out.println("Kapcsol�d�si pont hozz�adva.");
		/** Hozz�adja a kapcsol�d�si pontot a list�hoz*/
	}
}
