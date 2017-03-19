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
			System.out.println("Mozdony mozgása hibával. (1)");
			System.out.println("Mozdony áthalad az állomáson. (2)");
			System.out.println("Különleges helyen való kattintás. (3)");
			System.out.println("Váltó állítása. (4)");
			System.out.println("Kezdő pont. (5)");
			System.out.println("Játék vége. (6)");
			System.out.println("Teszt vége. (Q)");
			
			try {
				switch(s = new Bekeres().valaszbekeres()) {
								/* 1-3-ig mindig Mozdony().run függvénnyel kezdünk */
					case "1":
					case "2":
						//new Mozdony().run();
						System.out.println("Mozdony.run()");
						break;
					case "3":
						//new KulonlegesHely().checkTunnels();
						System.out.println("KulonlegesHely().checkTunnels()");
						break;
					case "4":
						new Valto(null).nextState();
						break;
					case "5":
						//new KezdoPont().work();
						System.out.println("KezdoPont().work()");
						break;
					case "6":
						System.out.println("Játék vége");
						break;
						/** Ezt még nem tudom.... */
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