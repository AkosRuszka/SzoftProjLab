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
		
		new VonatElem().getColor(); /* Aktu�lis rajta l�v� vagon (ami megh�vta r� a f�ggv�nyt) */
		
		System.out.println("Egyezik e a kocsi sz�ne az �llom�s�val ? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				new VonatElem().changeColor();
			} else {
				System.out.println("Nem t�rt�nik sz�nv�lt�s k�r�s.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Sin(null).getActVonatElem();
		new Sin(null).getActVonatElem();
		
		System.out.println("�tk�zni fogunk ? (I/N): ");
		try {
			if(new Bekeres().valaszbekeres().equals("I")) {
				System.out.println("Kisiklottunk, v�ge.");
			} else {
				System.out.println("Visszaadjuk az egyik Sin referenci�t");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
