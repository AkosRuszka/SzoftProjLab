package vasut;

import java.io.IOException;

public class Allomas extends Sin{
	
	public Allomas(Sin apoint_, String color_) {
		super(apoint_);
	}
	public String getColor() {
		/** Visszaadjuk a sz�nt */
		System.out.println("Sz�n lek�rdez�se.");
		return "Valami";
	}
	@Override
	public Sin actMove() {
		/** nem ugyan az fog t�rt�nni mint a sima sin actMove()-ban */
		System.out.println("�llom�s actMove() megh�vva.");
		VonatElem vagon = new VonatElem();
		//vagon.getColor();
		System.out.println("Egyezik e a kocsi sz�ne az �llom�s�val ? (I/N):  ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				/* ... */
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
