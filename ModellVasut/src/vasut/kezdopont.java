package vasut;


import java.io.IOException;
import java.util.*;
import vasut.*;

public class kezdopont extends Sin{
	//minden idõ [s]-ben értendõ
	private int time;				//0-tól a spawnTime-ig megy majd egy vonat lerakásakor újra nulla lesz
	private int spawnTime;			//két vonat indulása között eltelt idõ
	private int startTime;			//a játék indulása és az elsõ vonat indítása közötti idõ
	private int trains;				//a még indításra váró vonatok darabszáma (ha 0-nál kisebb, akkor végtelen)
	private List<Sin> spawnTunnel;	//ide rakja le a KezdoPont a vonatot (ezek a sínek láthatatlanok)
	private List<VonatElem> train;	//ebben a listában lesz az éppen lerakás alatt lévõ vonat.

	
	public kezdopont(Sin aPoint_, int spt, int stt, int tr) {
		super(aPoint_);
		time = 0;
		spawnTime = spt;
		startTime = stt;
		trains = tr;
		Sin seged;
		seged = new Sin(this); // ha ez az elsõ elem akkor közvetlenül a kezdõponthoz fog csatlakozni
		for (int i = 0; i < 9; i++) {							
			seged = new Sin(spawnTunnel.get(spawnTunnel.size()-1)); //az  új elem az elõzõhoz csatlakozik
			spawnTunnel.get(spawnTunnel.size()-1).setBPoint(seged); //a legutolsó elemet csatoljuk az újhoz
			spawnTunnel.add(seged);
		}
	}
	
	void SpawnTrain(){
		System.out.println("Hány kocsija legyen a vonatnak?");
		try {
			int i = System.in.read();
			train.add(new Mozdony()); //még nem származik le a mozdony a vonatelembõl de majd jó lesz :)
			for (int j = 0; j < i; j++) {
				train.add(new Kocsi(train.size()-1)); //még nincs Kocsi osztály de majd jó lesz :)
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	VonatElem work(){
		System.out.println("Jöjjön új vonat?	i/n");
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
