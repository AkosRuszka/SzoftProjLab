package vasut;

import java.util.*;

public class Jatek {
	private Palya actGame;	//a J�t�k tartalmazhat egy p�ly�t
	private int aktMap;		//aktu�lis p�lya
	private String sugo;	//a Sug� sz�vege
	
	public void newGame(){
		Palya seged = null;
		//itt majd bet�lti az els� p�ly�t...
		actGame = seged;
		actGame.run();
	}
	public void nextMap(){
		Palya seged = null;
		//itt majd bet�lti az k�vetkez� p�ly�t...
		actGame = seged;
		actGame.run();
	}
	public void mapLoad(){
		Palya seged = null;
		//itt majd bet�lt egy p�lya elmentett �ll�s�t...
		actGame = seged;
		actGame.run(); 
	}

}
