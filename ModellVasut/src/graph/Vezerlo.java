package graph;

import java.util.EventListener;
import java.util.EventObject;
import graph.*;
import vasut.Palya;

class Vezerlo implements EventListener{
	private View view = new View();
	//private Menu menu = new Menu();
	
	public void EventOccurred(RailEvent re){
		int event = re.getID();
		if(event == 0){
			view.newMapDraw((Palya)re.getSource());
		}
		else if(event == 1){
			view.mapRedraw();
		}
		else{
			//valami más
		}
		System.out.println(re.getSource());
		System.out.println(re.getID());
	}
}
