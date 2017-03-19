package vasut;

import java.io.IOException;
import java.util.*;
import vasut.*;

public class Kezdopont extends Sin{
	//minden id� [s]-ben �rtend�
	private int time;				//0-t�l a spawnTime-ig megy majd egy vonat lerak�sakor �jra nulla lesz
	private int spawnTime;			//k�t vonat indul�sa k�z�tt eltelt id�
	private int startTime;			//a j�t�k indul�sa �s az els� vonat ind�t�sa k�z�tti id�
	private int trains;				//a m�g ind�t�sra v�r� vonatok darabsz�ma (ha 0-n�l kisebb, akkor v�gtelen)
	private List<Sin> spawnTunnel;	//ide rakja le a KezdoPont a vonatot (ezek a s�nek l�thatatlanok)
	private List<VonatElem> train;	//ebben a list�ban lesz az �ppen lerak�s alatt l�v� vonat.

	
	public Kezdopont(Sin aPoint_, int spt, int stt, int tr) {
		super(aPoint_);
		//be�ll�todnak az attrib�tumok
		//elk�sz�k a "spawnTunnel"
	}
	
	public void SpawnTrain(){
		System.out.println("H�ny kocsija legyen a vonatnak?");
		try {
			int i = System.in.read();
			//a v�lasz alapj�n l�trehoz egy vonatot, min 2, vagy 3 kell h legyen majd		
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
	
	public VonatElem work(){
		System.out.println("J�jj�n �j vonat?	i/n");
		try {
			char c = (char)System.in.read();
			if(c=='i'){ // itt m�g ezer dolgot meg fog vizsg�lni h mikor j�jj�n vonat de majd csak a k�sz programban ;)
				SpawnTrain();
				return train.get(0);
			}					
		}
		catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
}
