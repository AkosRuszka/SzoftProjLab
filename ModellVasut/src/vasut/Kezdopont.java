package vasut;

import java.io.IOException;
import java.util.*;
import vasut.*;

public class Kezdopont extends Sin{
	
	private int time;				//0-tól a spawnTime-ig megy majd egy vonat lerakásakor újra nulla lesz
	private int spawnTime;			//két vonat indulása között eltelt idő
	private int startTime;			//a játék indulása és az első vonat indítása közötti idő
	private int trains;				//a még indításra váró vonatok darabszáma (ha 0-nál kisebb, akkor végtelen)
	private List<Sin> spawnTunnel;	//ide rakja le a KezdoPont a vonatot (ezek a sínek láthatatlanok)
	private List<VonatElem> train;	//ebben a listában lesz az éppen lerakás alatt lévő vonat.
	private boolean newspawn = true;//még nem rakott le vonatot 
	
	public Kezdopont(int spt, int stt, int tr) {
		time = 0;
		spawnTime = spt;
		startTime = stt;
		trains = tr;
				
		spawnTunnel.add(this);
		for (int i = 0; i < 7; i++) {
			Sin seged = new Sin(spawnTunnel.get(i));
			spawnTunnel.get(i).setBPoint(seged);
			spawnTunnel.add(seged);
		}
	}
	
	public void spawnTrain(){		
		
		try {
			train.add(new Mozdony());			train.get(0).changeColor();
			train.get(0).setWhereAmI(spawnTunnel.get(0));
			train.get(0).setFrontElem(null);
			spawnTunnel.get(0).setActVonatElem(train.get(0));
			train.add(new Kocsi("grey"));
			train.get(0).setBackElem(train.get(1));
			train.get(1).setWhereAmI(spawnTunnel.get(1));
			train.get(1).setFrontElem(train.get(0));
			train.get(1).setBackElem(null);
			spawnTunnel.get(1).setActVonatElem(train.get(1));
			Random rand = new Random();
			for (int i = 2; i < 7; i++) {				
				int color = rand.nextInt(6);
				switch (color) {
				case 1:
					train.add(new Kocsi("red"));
					break;
				case 2:
					train.add(new Kocsi("orange"));
					break;
				case 3:
					train.add(new Kocsi("yellow"));
					break;
				case 4:
					train.add(new Kocsi("green"));
					break;
				case 5:
					train.add(new Kocsi("blue"));
					break;
				case 6:
					train.add(new Kocsi("brown"));
					break;
				}
				train.get(i).setWhereAmI(spawnTunnel.get(i));
				train.get(i).setFrontElem(train.get(i-1));
				train.get(i).setBackElem(null);
				train.get(i-1).setBackElem(train.get(i));
				spawnTunnel.get(i).setActVonatElem(train.get(i));
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		System.out.println("Létrejött a vonat 5(+1) darab kocsival");
	}
	
	public VonatElem work(){
		if(newspawn){
			newspawn = false;
			if(time<startTime){
				time++;
				return null;
			}
			else{
				time = 0;
				spawnTrain();
				return train.get(0);
			}
		}
		else{
			if(time<spawnTime){
				time++;
				return null;
			}
			else{
				time = 0;
				spawnTrain();
				return train.get(0);
			}
		}
	}
}