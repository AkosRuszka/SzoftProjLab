package vasut;

import java.io.IOException;

public class Allomas extends Sin{
	
	public Allomas() {
		/** Jelenleg üres */
	}
	public String getColor() {
		/** Visszaadjuk a színt */
		System.out.println("Állomás színének lekérdezése.");
		return null;
	}
	@Override
	public Sin actMove() throws Exception {
		/** nem ugyan az fog történni mint a sima sin actMove()-ban */
		System.out.println("Állomás: actMove() függvény meghívva.");
		
		new VonatElem().getColor(); /* Aktuális rajta lévő vagon (ami meghívta rá a függvényt) */
		
		System.out.println("Állomas: Egyezik e a kocsi színe az állomáséval ? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				new VonatElem().changeColor();
			} else {
				System.out.println("Állomas: Nem történik színváltás.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Sin().getActVonatElem();
		new Sin().getActVonatElem();
		
		System.out.println("Állomás: Ütközni fog a vonat ? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				System.out.println("Állomás: A vonat ütközik.");
				throw new Exception("Játék vége ütközés miatt.");
			} else {
				System.out.println("Állomás: visszaadjuk az egyik Sin referenciát");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}