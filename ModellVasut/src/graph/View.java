package graph;

import java.awt.Point;
import java.util.ArrayList;
import graph.*;
import vasut.Kocsi;
import vasut.Mozdony;
import vasut.Palya;
import vasut.Sin;
import vasut.VonatElem;

public class View {
	ArrayList<IRajzolo> railElements = new ArrayList<IRajzolo>();
	ArrayList<IRajzolo> trainElements = new ArrayList<IRajzolo>();
	public void mapRedraw(){
		for(IRajzolo trains : trainElements){
			for(IRajzolo rails : railElements){
				if(((Sin) rails.getObject()).getActVonatElem() == ((VonatElem)trains.getObject())){
					Point a = new Point();
					a.setLocation(trains.getCoord().getX()+2, trains.getCoord().getY()+2);
					rails.setCoord(a);
				}
			}
		}
	}
	
	public void newMapDraw(Palya actMap){
		for(Sin s : actMap.getMap()){
			//meh na ide kérek segítséget hogy rakom ki az elemeket
		}
		for(Mozdony s : actMap.getEngines()){
			//itt minden vonatnak kéne csinálni egy rajoltat :D 
		}
	}
	
	public void addTrain(Palya p){
		Mozdony e1 = p.getEngines().get(p.getEngines().size()-1);
		trainElements.add(new MozdonyRajzolo(null, null, e1));
		for(Kocsi e = (Kocsi) e1.getBackElem(); e!=null; e = (Kocsi) e.getBackElem()){
			//trainElements.add(new KocsiRajzolo(, null, e));
		}
	}
}
