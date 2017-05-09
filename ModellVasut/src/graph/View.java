package graph;

import java.awt.Point;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JFrame;

import graph.*;
import vasut.Kocsi;
import vasut.Mozdony;
import vasut.Palya;
import vasut.Sin;
import vasut.VonatElem;

public class View extends JFrame{
	ArrayList<IRajzolo> railElements = new ArrayList<IRajzolo>();
	ArrayList<MozdonyRajzolo> trainElements = new ArrayList<MozdonyRajzolo>();
	ArrayList<KocsiRajzolo> cartElements = new ArrayList<KocsiRajzolo>();
	public void mapRedraw(){
		for(MozdonyRajzolo trains : trainElements){
			boolean mapon = false;
			for(IRajzolo rails : railElements){
				if(((Sin) rails.getObject()).getActVonatElem() == ((VonatElem)trains.getObject())){
					Point a = new Point();
					/* Lemásoljuk a "tartalmazó" sin koordinátáját. */
					a.setLocation(rails.getPoint().getX(), rails.getPoint().getY());
					/* Átállítjuk a mozdony/kocsi koordinátáját. */
					trains.setPoint(a);
					mapon = true;
					trains.setVisible(true);
				}
			}
			if(!mapon){
				trains.setVisible(false);
			}
		}
		for(KocsiRajzolo carts : cartElements){
			boolean mapon = false;
			for(IRajzolo rails : railElements){
				if(((Sin) rails.getObject()).getActVonatElem() == ((VonatElem)carts.getObject())){
					Point a = new Point();
					/* Lemásoljuk a "tartalmazó" sin koordinátáját. */
					a.setLocation(rails.getPoint().getX(), rails.getPoint().getY());
					/* Átállítjuk a mozdony/kocsi koordinátáját. */
					carts.setPoint(a);
					mapon = true;
					carts.setVisible(true);
				}
			}
			if(!mapon){
				carts.setVisible(false);
			}
		}
		this.invalidate();
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
		//trainElements.add(new MozdonyRajzolo(null, null, e1));
		for(Kocsi e = (Kocsi) e1.getBackElem(); e!=null; e = (Kocsi) e.getBackElem()){
			//cartElements.add(new KocsiRajzolo(, null, e));
		}
	}
}
