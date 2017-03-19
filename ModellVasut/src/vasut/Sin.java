package vasut;

import java.io.IOException;

public class Sin {

	public Sin(Sin aPoint_){
		/** Megkapja az egyik már létrehozott oldalát, többit nullázza. */

	}
	public Sin getAPoint() {
		/** Lekérdezi az aPontot */
		System.out.println("Lekérdezzük az A pontot.");
		return null;
	}
	public Sin getBPoint() {
		/** Lekérdezi a bPontot */
		System.out.println("Lekérdezzük a B pontot.");
		return new Sin(this);
	}
	public void setAPoint(Sin ap) {
		/** Beállítja az aPontot */
		System.out.println("Beállítjuk az A pontot.");
	}
	public void setBPoint(Sin bp) {
		/** Beállítja a bPontot */
		System.out.println("Beállítjuk a B pontot.");
	}
	public void setActVonatElem(VonatElem akt) {
		/** Beállítjuk a actVonatElem-et */
		System.out.println("Beállítjuk a Sin-en lévõ Mozdonyt.");
	}
	public VonatElem getActVonatElem() {
		/** Lekérdezzük az actVonatElem-et */
		System.out.println("Lekérdezzük a Sin-en lévõ Mozdonyt.");
		return null;
	}
	public Sin actMove() throws Exception {
		/** Visszaadjuk hogy merre mehet a vonat */
		System.out.println("Meghívódott az actMove() függvény.");
		
		new Sin(null).getActVonatElem();
		new Sin(null).getActVonatElem();
		
		System.out.println("Ütközni fog a vonat ? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				System.out.println("Kisiklottunk, vége.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
