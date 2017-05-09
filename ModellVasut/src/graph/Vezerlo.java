package graph;

import java.util.EventListener;
import java.util.EventObject;
import graph.*;
import vasut.Jatek;
import vasut.Palya;

public class Vezerlo implements EventListener{
	private View view = null;
	private Menu menu = null;
	private Jatek jatek = null;
	private Palya palya = null;
	
	public Vezerlo(View v,Menu m, Jatek j){
		view = v;
		menu = m;
		jatek = j;
		jatek.addActionListener(this);
	}
	
	public void EventOccurred(RailEvent re){
		int event = re.getID();
		if(event == 0){
			palya = (Palya)re.getSource();
			palya.addActionListener(this);
			menu.setVisible(false);
			view.setVisible(true);
			view.newMapDraw((Palya)re.getSource());
		}
		else if(event == 1){
			menu.setVisible(false);
			view.setVisible(true);
			view.mapRedraw();
		}
		else if(event == 2){
			menu.setVisible(true);
			view.setVisible(false);
		}
		else if(event == 3){
			view.addTrain((Palya)re.getSource());
		}
		else{
			//valami más
		}
		System.out.println(re.getSource());
		System.out.println(re.getID());
	}
}
