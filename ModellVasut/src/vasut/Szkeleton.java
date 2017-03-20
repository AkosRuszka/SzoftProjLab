package vasut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Szkeleton {

	public static void main(String[] args) throws Exception {
		String s = "Q";
		do {
			/* Itt kéne valami console clear... */
			
			System.out.println("Válassz teszteseteket az alábbiak közül.\n");
			System.out.println("Mozdony mozgása. (1)");
			System.out.println("Különleges helyen való kattintás. (2)");
			System.out.println("Váltó állítása. (3)");
			System.out.println("Kezdő pont. (4)");
			System.out.println("Játék vége. (5)");
			System.out.println("Új Pálya. (6)");
			System.out.println("Következő pálya. (7)");
			System.out.println("Pálya Betöltése. (8)");
			System.out.println("Teszt vége. (Q)");
			
			try {
				switch(s = new Bekeres().valaszbekeres()) {
					case "1":
						try {
							new Mozdony().run();
						} catch(Exception e) {
							System.out.println(e); // speciális eset lejátszása, a mozdony dobhat kivételt ezért felkészítjük rá.
						}
						break;
					case "2":
						new KulonlegesHely().checkTunnels();
						break;
					case "3":
						new Valto().nextState();
						break;
					case "4":
						new Kezdopont().work();
						break;
					case "5":
						System.out.println("Játék vége");
						break;
						/** Ezt még nem tudom.... */
					case "6":
						new Jatek().newGame();
						break;
					case "7":
						new Jatek().nextMap();
						break;
					case "8":
						new Jatek().mapLoad();
						break;
					case "Q": 
						/* Nem csinálunk itt semmit, csak a default üzenet kiküszöbölésére kell. */
						break;
					default:
						System.out.println("Nem megfelelő választás.");
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("\n\n"); /* Ha van console clear akkor ez nem kell... */
		} while(!s.equals("Q"));
		System.out.println("Kilépünk a szkeletonból.");
	}
}

class Bekeres {
	String valaszbekeres() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String valasz = br.readLine();
		return valasz;
	}
}