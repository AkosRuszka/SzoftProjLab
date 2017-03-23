package vasut;

public class Allomas extends Sin{
	private String color;
	
	public Allomas(Sin aPoint_ , String color_){
		super(aPoint_);
		color = color_;
	}
	
	
	/* Csak sintax error kiküszöbölésére, majd ki kell törölni! */
	public Allomas() {
	}
	
	
	public String getColor() {
		/** Visszaadjuk a színt */
		System.out.println("Állomás színének lekérdezése.");
		return color;
	}
	@Override
	public Sin actMove() throws Exception {
		System.out.println("Állomás: actMove() függvény meghívva.");
		
		/* Vizsgáljuk a rajta áthaladó kocsi színét */
		if(actVonatElem.getColor().equals(color)) {
			actVonatElem.changeColor();
		}
		return super.actMove();
	}
}