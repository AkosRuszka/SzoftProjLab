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
		
		System.out.println("Mi legyen az esemény ? ");
		System.out.println("Vonat kisiklik (1)");
		System.out.println("Vonat ütközik (2)");
		System.out.print("Vonat szépen fut tovább (3");
		
		try {
			switch(new Bekeres().valaszbekeres()) {
				case "1":
					System.out.println("A szomszéd sin null-ra mutat, azzal térünk vissza.");
					return null;
				case "2":
					System.out.print("Mindkét szomszédon van Vonat, ezért exceptiont dobunk.");
					/** Itt kéne dobni egy exception-t, csakhogy nem itt kéne elkapnunk...*/
				case "3":
					
				default:
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
