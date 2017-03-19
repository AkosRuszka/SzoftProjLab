package vasut;

import java.util.*;

public class Jatek {
	private Palya actGame;	//a Játék tartalmazhat egy pályát
	private int aktMap;		//aktuális pálya
	private String sugo;	//a Sugó szövege
	
	public void newGame(){
		Palya seged = null;
		//itt majd betölti az elsõ pályát...
		actGame = seged;
		actGame.run();
	}
	public void nextMap(){
		Palya seged = null;
		//itt majd betölti az következõ pályát...
		actGame = seged;
		actGame.run();
	}
	public void mapLoad(){
		Palya seged = null;
		//itt majd betölt egy pálya elmentett állását...
		actGame = seged;
		actGame.run(); 
	}

}
