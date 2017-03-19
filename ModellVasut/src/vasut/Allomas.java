package vasut;

public class Allomas extends Sin{
	
	public Allomas(Sin apoint_, String color_) {
		super(apoint_);
	}
	public String getColor() {
		/** Visszaadjuk a színt */
		System.out.println("Szín lekérdezése.");
		return "Valami";
	}
	@Override
	public Sin actMove() {
		/** nem ugyan az fog történni mint a sima sin actMove()-ban */
		System.out.println("Állomás actMove() meghívva.");
		return null;
	}
}
