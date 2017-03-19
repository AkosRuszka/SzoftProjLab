package vasut;

import java.io.IOException;

public class Allomas extends Sin{
	
	public Allomas(Sin apoint_, String color_) {
		super(apoint_);
	}
	public String getColor() {
		/** Visszaadjuk a sz�nt */
		System.out.println("�llom�s sz�n�nek lek�rdez�se.");
		return null;
	}
	@Override
	public Sin actMove() {
		/** nem ugyan az fog t�rt�nni mint a sima sin actMove()-ban */
		System.out.println("�llom�s actMove() megh�vva.");
		
		VonatElem actvonatelem = new VonatElem(); /* Aktu�lis rajta l�v� vagon (ami megh�vta r� a f�ggv�nyt) */
		actvonatelem.getColor();
		
		System.out.println("Egyezik e a kocsi sz�ne az �llom�s�val ? (I/N):  ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				actvonatelem.changeColor();
				
			} else {
				System.out.println("Nem t�rt�nik sz�nv�lt�s k�r�s.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Sin(null).getActVonatElem();
		new Sin(null).getActVonatElem();
		System.out.println("Visszaadjuk az egyik Sin referenci�t");
		return null;
	}
}
