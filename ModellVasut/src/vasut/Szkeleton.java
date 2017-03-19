package vasut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Szkeleton {

	public static void main(String[] args) {
		String s = "Q";
		do {
			/* Itt kéne valami console clear... */
			
			System.out.println("Válassz teszteseteket az alábbiak közül.\n");
			System.out.println("Vonat áthalad az állomáson. (1)");
			System.out.println("Két vonat ütközik. (2)");
			System.out.println("Vonat kisiklása. (3)");
			System.out.println("Különleges helyen való kattintás. (4)");
			System.out.println("Váltó állítása. (5)");
			System.out.println("Kezdõ pont. (6)");
			System.out.println("Játék vége. (7)");
			System.out.println("Teszt vége. (Q)");
			
			try {
				switch(s = new Bekeres().valaszbekeres()) {
					case "1": /* 1-3-ig mindig Mozdony().run függvénnyel kezdünk */
					case "2":
					case "3":
						//new Mozdony().run();
						System.out.println("Mozdony.run()");
						break;
					case "4":
						//new KulonlegesHely().checkTunnels();
						System.out.println("KulonlegesHely().checkTunnels()");
						break;
					case "5":
						new Valto(null).nextState();
						break;
					case "6":
						//new KezdoPont().work();
						System.out.println("KezdoPont().work()");
						break;
					case "7":
						System.out.println("Játék vége");
						break;
						/** Ezt még nem tudom.... */
					case "Q": 
						/* Nem csinálunk itt semmit, csak a default üzenet kiküszöbölésére kell. */
						break;
					default:
						System.out.println("Nem megfelelõ választás.");
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