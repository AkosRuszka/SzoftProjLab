package graph;

import java.awt.Insets;
import java.awt.Point;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import graph.*;
import vasut.Allomas;
import vasut.Kocsi;
import vasut.KulonlegesHely;
import vasut.Mozdony;
import vasut.Palya;
import vasut.Sin;
import vasut.Valto;
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
		int i = 0;
		int j = 0;
		for(Sin s[][] = actMap.getMap(); i < 30; i++){
			for(; j < 30; j++){
				// TODO: Labelek kirajzolása
			}		
		}
		//for(Mozdony s : actMap.getEngines()){
			//itt minden vonatnak kéne csinálni egy rajoltat :D 
		//}
	}
	
	public void mapfeldolgozas(Sin mymapp[][]) {
		
		Insets insets = this.getInsets();
		
		SinRajzolo ujsin;
		AllomasRajzolo ujallomas;
		KulonlegesHelyRajzolo ujkulhely;
		ValtoRajzolo ujvalto;
		
		for(int x=0; x<30; x++) {
			for(int y=0; y<30; y++) {
				if(mymapp[x][y] != null){
					switch((mymapp[x][y]).getType()) {
					case "Sin":
						ujsin = new SinRajzolo(new Point((x+1)*20, (y+1)*20),mymapp[x][y],insets);
						railElements.add(ujsin);
						add(ujsin);
						break;
					case "Allomas":
						/* Hozzáadjuk a framehez már itt a nyilat, amit az állomásoknál szeretnénk megjeleníteni
						 * mivel az állomásnak meg kell kapnia azt a nyil referenciát ami már rajta van a frame-n */
						JLabel nyil = new JLabel();
						add(nyil);
						ujallomas = new AllomasRajzolo(new Point((x+1)*20, (y+1)*20),(Allomas)mymapp[x][y],insets, nyil);
						railElements.add(ujallomas);
						add(ujallomas);
						break;
					case "KulonlegesHely":
						ujkulhely = new KulonlegesHelyRajzolo(new Point((x+1)*20, (y+1)*20),(KulonlegesHely)mymapp[x][y],insets);
						railElements.add(ujkulhely);
						add(ujkulhely);
						break;
					case "Valto":
						ujvalto = new ValtoRajzolo(new Point((x+1)*20,(x+1)*20),(Valto)mymapp[x][y],insets);
						railElements.add(ujvalto);
						add(ujvalto);
						break;
					}
				}
			}
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
