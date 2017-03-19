package vasut;

import java.io.IOException;

public class Allomas extends Sin{
	
	public Allomas(Sin apoint_, String color_) {
		super(apoint_);
	}
	public String getColor() {
		/** Visszaadjuk a színt */
		System.out.println("Állomás színének lekérdezése.");
		return null;
	}
	@Override
	public Sin actMove() {
		/** nem ugyan az fog történni mint a sima sin actMove()-ban */
		System.out.println("Állomás actMove() meghívva.");
		
		new VonatElem().getColor(); /* Aktuális rajta lévõ vagon (ami meghívta rá a függvényt) */
		
		System.out.println("Egyezik e a kocsi színe az állomáséval ? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				new VonatElem().changeColor();
			} else {
				System.out.println("Nem történik színváltás kérés.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Sin(null).getActVonatElem();
		new Sin(null).getActVonatElem();
		
		System.out.println("Ütközni fogunk ? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				System.out.println("Kisiklottunk, vége.");
			} else {
				System.out.println("Visszaadjuk az egyik Sin referenciát");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
