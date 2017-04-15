package vasut;

public class Kocsi extends VonatElem {
	
	public Kocsi(Sin whereAmI_, VonatElem frontElem_, Kocsi backElem_, String color_){
		super(whereAmI_, frontElem_, backElem_, color_);
	}
	
	public void pull() throws Exception {
		/** A mozdony hívja meg az osztálynak ezt a függvényét ha a kocsinak át kell mennie a következő sínre. A sínek segítségével pedig arrébb tudd mozogni a megfelelő irányba. */
		System.out.println("Kocsi pull függvénye meghívódott");
		whereAmI.setActVonatElem(null);
		whereAmI = whereAmI.actMove();
		whereAmI.setActVonatElem(this);
		if(backElem != null)
			backElem.pull();
	}
}