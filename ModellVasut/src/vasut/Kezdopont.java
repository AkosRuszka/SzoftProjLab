package vasut;

import java.io.IOException;
import java.util.*;
import vasut.*;

public class Kezdopont extends Sin{
	
	private int time;				//0-tól a spawnTime-ig megy majd egy vonat lerakásakor újra nulla lesz
	private int spawnTime;			//két vonat indulása között eltelt idő
	private int startTime;			//a játék indulása és az első vonat indítása közötti idő
	private int trains;				//a még indításra váró vonatok darabszáma (ha 0-nál kisebb, akkor végtelen)
	private ArrayList<Sin> spawnTunnel;	//ide rakja le a KezdoPont a vonatot (ezek a sínek láthatatlanok)
	private ArrayList<VonatElem> train;	//ebben a listában lesz az éppen lerakás alatt lévő vonat.
	private boolean newspawn;//még nem rakott le vonatot 
	
	public Kezdopont(int spt, int stt, int tr, Sin A) {
		super(A);
		spawnTunnel = new ArrayList<Sin>();
		train = new ArrayList<VonatElem>();
		time = 0;
		spawnTime = spt;
		startTime = stt;
		trains = tr;
		newspawn = true;
		
		System.out.println("SpawnTunnel setup:");
		spawnTunnel.add(this);
		for (int i = 0; i < 7; i++) {
			Sin seged = new Sin(spawnTunnel.get(i));
			seged.setBPoint(null);
			spawnTunnel.get(i).setBPoint(seged);
			spawnTunnel.add(seged);
		}
		System.out.println("SpawnTunnel setup end");
	}
	
	public void spawnTrain(){		
		
		try {
			train.add(new Mozdony(spawnTunnel.get(0)));
			spawnTunnel.get(0).setActVonatElem(train.get(0));
			
			train.add(new Kocsi(spawnTunnel.get(1), train.get(0), null,"grey"));
			train.get(0).setBackElem((Kocsi)train.get(1));
			spawnTunnel.get(1).setActVonatElem(train.get(1));
			
			Random rand = new Random();
			for (int i = 2; i < 7; i++) {				
				int color = rand.nextInt(4);
				switch (color) {
				case 0:
					train.add(new Kocsi(spawnTunnel.get(i),train.get(i-1),null,"red"));
					break;
				case 1:
					train.add(new Kocsi(spawnTunnel.get(i),train.get(i-1),null,"yellow"));
					break;
				case 2:
					train.add(new Kocsi(spawnTunnel.get(i),train.get(i-1),null,"green"));
					break;
				case 3:
					train.add(new Kocsi(spawnTunnel.get(i),train.get(i-1),null,"blue"));
					break;
				}
				train.get(i-1).setBackElem((Kocsi)train.get(i));
				spawnTunnel.get(i).setActVonatElem(train.get(i));
			}
		}
		catch (Exception e) {
			
			System.out.print(e.getMessage());
		}
		System.out.println("Létrejött a vonat 5(+1) darab kocsival");
	}
	
	public Mozdony work(){
		if(trains>0){
			System.out.println("Kezdopont.work()");
			if(newspawn){
				newspawn = false;
				if(time<startTime){
					time++;
					return null;
				}
				else{
					time = 0;
					spawnTrain();
					trains--;
					return (Mozdony)train.get(0);
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
					trains--;
					return (Mozdony)train.get(0);
				}
			}
		}
		else{
			System.out.println("Nincs több vonat!");
			return null;
		}
	}
}