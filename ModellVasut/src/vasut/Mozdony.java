package vasut;

import java.io.IOException;

public class Mozdony extends VonatElem {
	
	public Mozdony(){};
	
	public boolean run() throws IOException {
		/** Elindul a mozdony és maga után húzza a kocsijait. */
		System.out.println("Megindul a vonat. Van előttem sín?");
		if(new Bekeres().valaszbekeres().equals("I"))
			return true;
		else
			return false;
 			
	}
}
