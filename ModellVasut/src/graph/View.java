package graph;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private Vezerlo listener;
	
	public View() {
		setLayout(null);
		setVisible(true);
		setSize(new Dimension(900,900));
		/* ujrarajzolást kérünk */
		
		invalidate();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setVezerlo(Vezerlo v){
		listener = v;
	}
	
	public void mapRedraw(){
		for(MozdonyRajzolo trains : trainElements){
			boolean mapon = false;
			for(IRajzolo rails : railElements){
				if(((Sin)(rails.getObject())).getActVonatElem() == ((VonatElem)trains.getObject())){
					/* Átállítjuk a mozdony/kocsi koordinátáját. */
					trains.setPoint(rails.getPoint());
					mapon = true;
					trains.setVisible(true);
				}
			}
			if(!mapon){
				trains.setVisible(true);
			}
		}
		for(KocsiRajzolo carts : cartElements){
			boolean mapon = false;
			for(IRajzolo rails : railElements){
				if(((Sin) rails.getObject()).getActVonatElem() == ((VonatElem)carts.getObject())){
					carts.setPoint(rails.getPoint());
					mapon = true;
					carts.setVisible(true);
				}
			}
			if(!mapon){
				carts.setVisible(true);
			}
		}
		repaint();
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
		
		JButton sts = new JButton("start/stop");
		try{			
			ImageIcon print_img = new ImageIcon(".\\img\\startstop.png");			
			
			// 20x20-as átméretezés
			Image resizedImage = print_img.getImage();
			Image newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			print_img = new ImageIcon(newimg);
			sts.setIcon(print_img);
		}
		catch (Exception e) {
			e.getMessage();
		}
		Dimension size = getPreferredSize();
		sts.setBounds(insets.left, insets.top,
	             20, 20);
		sts.setAlignmentX(Component.CENTER_ALIGNMENT);
		sts.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				//event----------------------------------
				RailEvent re = new RailEvent(this, 5, listener);
				re.fire();
				//endevent-------------------------------	
			  }
		});		
		
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
						ujvalto = new ValtoRajzolo(new Point((x+1)*20,(y+1)*20),(Valto)mymapp[x][y],insets);
						railElements.add(ujvalto);
						add(ujvalto);
						break;
					}
				}
			}
		}
		repaint();
	}
	
	public void addTrain(Mozdony p, int x, int y){
		MozdonyRajzolo m = new MozdonyRajzolo(new Point((x+1)*20, (y+1)*20), p, this.getInsets());
		trainElements.add(m);
		add(m);		
	}
	public void addCart(Kocsi p, int x, int y){
		KocsiRajzolo m = new KocsiRajzolo(new Point((x+1)*20, (y+1)*20), p, this.getInsets());
		cartElements.add(m);
		add(m);		
	}
}
