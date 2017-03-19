package vasut;

import java.io.IOException;

public class Sin {

	public Sin(){
		/** Megkapja az egyik már létrehozott oldalát, többit nullázza. */

	}
	public Sin getAPoint() {
		/** Lekérdezi az aPontot */
		System.out.println("Sin: A pont lekérdezése");
		return null;
	}
	public Sin getBPoint() {
		/** Lekérdezi a bPontot */
		System.out.println("Sin: B pont lekérdezése");
		return new Sin();
	}
	public void setAPoint(Sin ap) {
		/** Beállítja az aPontot */
		System.out.println("Sin: A pontot beállítása.");
	}
	public void setBPoint(Sin bp) {
		/** Beállítja a bPontot */
		System.out.println("Sin: B pontot beállítása.");
	}
	public void setActVonatElem(VonatElem akt) {
		/** Beállítjuk a actVonatElem-et */
		System.out.println("Sin: mozdony beállítása.");
	}
	public VonatElem getActVonatElem() {
		/** Lekérdezzük az actVonatElem-et */
		System.out.println("Sin: mozdony lekérdezése");
		return null;
	}
	public Sin actMove() throws Exception {
		/** Visszaadjuk hogy merre mehet a vonat */
		System.out.println("Sin: actMove() függvényt meghívták.");
		
		new Sin().getActVonatElem();
		new Sin().getActVonatElem();
		
		System.out.println("Sin: ütközni fog a vonat ? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				System.out.println("Sin: a vonat ütközik.");
				throw new Exception("Játék vége ütközés miatt.");
			} else {
				System.out.println("Sin: visszaadjuk az egyik Sin referenciát");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}