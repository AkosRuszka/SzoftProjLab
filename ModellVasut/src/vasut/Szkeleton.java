package vasut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Szkeleton {

	public static void main(String[] args) {
		String s = "Q";
		do {
			/* Itt k�ne valami console clear... */
			
			System.out.println("V�lassz teszteseteket az al�bbiak k�z�l.\n");
			System.out.println("Mozdony mozg�sa hib�val. (1)");
			System.out.println("Mozdony �thalad az �llom�son. (2)");
			System.out.println("K�l�nleges helyen val� kattint�s. (3)");
			System.out.println("V�lt� �ll�t�sa. (4)");
			System.out.println("Kezd� pont. (5)");
			System.out.println("J�t�k v�ge. (6)");
			System.out.println("Teszt v�ge. (Q)");
			
			try {
				switch(s = new Bekeres().valaszbekeres()) {
								/* 1-3-ig mindig Mozdony().run f�ggv�nnyel kezd�nk */
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
						System.out.println("J�t�k v�ge");
						break;
						/** Ezt m�g nem tudom.... */
					case "Q": 
						/* Nem csin�lunk itt semmit, csak a default �zenet kik�sz�b�l�s�re kell. */
						break;
					default:
						System.out.println("Nem megfelel� v�laszt�s.");
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("\n\n"); /* Ha van console clear akkor ez nem kell... */
		} while(!s.equals("Q"));
		System.out.println("Kil�p�nk a szkeletonb�l.");
	}
}

class Bekeres {
	String valaszbekeres() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String valasz = br.readLine();
		return valasz;
	}
}