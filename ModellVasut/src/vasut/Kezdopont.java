package vasut;

import java.io.IOException;
import java.util.*;
import vasut.*;

public class Kezdopont extends Sin{
	//minden idõ [s]-ben értendõ
	private int time;				//0-tól a spawnTime-ig megy majd egy vonat lerakásakor újra nulla lesz
	private int spawnTime;			//két vonat indulása között eltelt idõ
	private int startTime;			//a játék indulása és az elsõ vonat indítása közötti idõ
	private int trains;				//a még indításra váró vonatok darabszáma (ha 0-nál kisebb, akkor végtelen)
	private List<Sin> spawnTunnel;	//ide rakja le a KezdoPont a vonatot (ezek a sínek láthatatlanok)
	private List<VonatElem> train;	//ebben a listában lesz az éppen lerakás alatt lévõ vonat.

	
	public Kezdopont(Sin aPoint_, int spt, int stt, int tr) {
		super(aPoint_);
		//beállítodnak az attribútumok
		//elkészük a "spawnTunnel"
	}
	
	public void SpawnTrain(){
		System.out.println("Hány kocsija legyen a vonatnak?");
		try {
			int i = System.in.read();
			//a válasz alapján létrehoz egy vonatot, min 2, vagy 3 kell h legyen majd		
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
	
	public VonatElem work(){
		System.out.println("Jöjjön új vonat?	i/n");
		try {
			char c = (char)System.in.read();
			if(c=='i'){ // itt még ezer dolgot meg fog vizsgálni h mikor jöjjön vonat de majd csak a kész programban ;)
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
