package vasut;

import java.io.IOException;

public class Sin {

	public Sin(Sin aPoint_){
		/** Megkapja az egyik m�r l�trehozott oldal�t, t�bbit null�zza. */

	}
	public Sin getAPoint() {
		/** Lek�rdezi az aPontot */
		System.out.println("Lek�rdezz�k az A pontot.");
		return null;
	}
	public Sin getBPoint() {
		/** Lek�rdezi a bPontot */
		System.out.println("Lek�rdezz�k a B pontot.");
		return new Sin(this);
	}
	public void setAPoint(Sin ap) {
		/** Be�ll�tja az aPontot */
		System.out.println("Be�ll�tjuk az A pontot.");
	}
	public void setBPoint(Sin bp) {
		/** Be�ll�tja a bPontot */
		System.out.println("Be�ll�tjuk a B pontot.");
	}
	public void setActVonatElem(VonatElem akt) {
		/** Be�ll�tjuk a actVonatElem-et */
		System.out.println("Be�ll�tjuk a Sin-en l�v� Mozdonyt.");
	}
	public VonatElem getActVonatElem() {
		/** Lek�rdezz�k az actVonatElem-et */
		System.out.println("Lek�rdezz�k a Sin-en l�v� Mozdonyt.");
		return null;
	}
	public Sin actMove() throws Exception {
		/** Visszaadjuk hogy merre mehet a vonat */
		System.out.println("Megh�v�dott az actMove() f�ggv�ny.");
		
		new Sin(null).getActVonatElem();
		new Sin(null).getActVonatElem();
		
		System.out.println("Mi legyen az esem�ny ? ");
		System.out.println("Vonat kisiklik (1)");
		System.out.println("Vonat �tk�zik (2)");
		System.out.print("Vonat sz�pen fut tov�bb (3");
		
		try {
			switch(new Bekeres().valaszbekeres()) {
				case "1":
					System.out.println("A szomsz�d sin null-ra mutat, azzal t�r�nk vissza.");
					return null;
				case "2":
					System.out.print("Mindk�t szomsz�don van Vonat, ez�rt exceptiont dobunk.");
					/** Itt k�ne dobni egy exception-t, csakhogy nem itt k�ne elkapnunk...*/
				case "3":
					
				default:
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
