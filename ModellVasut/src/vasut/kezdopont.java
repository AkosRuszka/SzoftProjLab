package vasut;


import java.io.IOException;
import java.util.*;
import vasut.*;

public class kezdopont extends Sin{
	//minden id� [s]-ben �rtend�
	private int time;				//0-t�l a spawnTime-ig megy majd egy vonat lerak�sakor �jra nulla lesz
	private int spawnTime;			//k�t vonat indul�sa k�z�tt eltelt id�
	private int startTime;			//a j�t�k indul�sa �s az els� vonat ind�t�sa k�z�tti id�
	private int trains;				//a m�g ind�t�sra v�r� vonatok darabsz�ma (ha 0-n�l kisebb, akkor v�gtelen)
	private List<Sin> spawnTunnel;	//ide rakja le a KezdoPont a vonatot (ezek a s�nek l�thatatlanok)
	private List<VonatElem> train;	//ebben a list�ban lesz az �ppen lerak�s alatt l�v� vonat.

	
	public kezdopont(Sin aPoint_, int spt, int stt, int tr) {
		super(aPoint_);
		time = 0;
		spawnTime = spt;
		startTime = stt;
		trains = tr;
		Sin seged;
		seged = new Sin(this); // ha ez az els� elem akkor k�zvetlen�l a kezd�ponthoz fog csatlakozni
		for (int i = 0; i < 9; i++) {							
			seged = new Sin(spawnTunnel.get(spawnTunnel.size()-1)); //az  �j elem az el�z�hoz csatlakozik
			spawnTunnel.get(spawnTunnel.size()-1).setBPoint(seged); //a legutols� elemet csatoljuk az �jhoz
			spawnTunnel.add(seged);
		}
	}
	
	void SpawnTrain(){
		System.out.println("H�ny kocsija legyen a vonatnak?");
		try {
			int i = System.in.read();
			train.add(new Mozdony()); //m�g nem sz�rmazik le a mozdony a vonatelemb�l de majd j� lesz :)
			for (int j = 0; j < i; j++) {
				train.add(new Kocsi(train.size()-1)); //m�g nincs Kocsi oszt�ly de majd j� lesz :)
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	VonatElem work(){
		System.out.println("J�jj�n �j vonat?	i/n");
		try {
			char c = (char)System.in.read();
			if(c=='i'){
				SpawnTrain();
				return train.get(0);
			}
			return null;
					
		}
		catch (IOException e) {
			System.out.print(e.getMessage());
		}		
		return train.get(0);
	}
}
