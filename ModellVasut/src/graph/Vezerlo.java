package graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import vasut.Jatek;
import vasut.Kezdopont;
import vasut.Mozdony;
import vasut.Palya;
import vasut.Sin;

public class Vezerlo implements ActionListener, Serializable{
	private View view = null;
	private Menu menu = null;
	private Jatek jatek = null;
	private Palya palya = null;
	
	public Vezerlo(View v,Menu m, Jatek j){
		view = v;
		menu = m;
		jatek = j;
		jatek.addActionListener(this);
		menu.addActionListener(this);
		
		//Thread t = new Thread(run());
		run();
	}
	
	public void run(){
		synchronized (this){
			view.mapfeldolgozas(izebezi());
			palya.addActionListener(this);
			view.mapRedraw();
			try {
				palya.setStartStop();
			} catch (Exception e) {
				e.printStackTrace();
			}
			palya.run();
		}
	}
	
	public void EventOccurred(RailEvent re){
		synchronized (this){
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
				//view.addTrain(((Palya)re.getSource()));
			}
			else{
				//valami más
			}
			System.out.println(re.getSource());
			System.out.println(re.getID());
		}
	}
	
	public Sin[][] izebezi() {
		Sin mymap[][] = new Sin[30][30];
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				mymap[i][j] = null;
			}
		}
		jatek.makeGame();
		palya = jatek.getGame();
		mymap[10][10] = new Sin(null);
		palya.addToMap(mymap[10][10]);
		mymap[11][10] = new Sin(mymap[10][10]);
		palya.addToMap(mymap[11][10]);
		mymap[12][10] = new Sin(mymap[11][10]);
		palya.addToMap(mymap[12][10]);
		mymap[13][10] = new Sin(mymap[12][10]);
		palya.addToMap(mymap[13][10]);
		mymap[14][10] = new Sin(mymap[13][10]);
		palya.addToMap(mymap[14][10]);
		mymap[15][10] = new Sin(mymap[14][10]);
		palya.addToMap(mymap[15][10]);
		mymap[16][10] = new Sin(mymap[15][10]);
		palya.addToMap(mymap[16][10]);
		mymap[17][10] = new Sin(mymap[16][10]);
		palya.addToMap(mymap[17][10]);
		mymap[17][11] = new Sin(mymap[17][10]);
		palya.addToMap(mymap[17][11]);
		mymap[17][12] = new Sin(mymap[17][11]);
		palya.addToMap(mymap[17][12]);
		mymap[17][13] = new Sin(mymap[17][12]);
		palya.addToMap(mymap[17][13]);
		mymap[17][14] = new Sin(mymap[17][13]);
		palya.addToMap(mymap[17][14]);
		mymap[16][14] = new Sin(mymap[17][14]);
		palya.addToMap(mymap[16][14]);
		mymap[15][14] = new Sin(mymap[16][14]);
		palya.addToMap(mymap[15][14]);
		mymap[14][14] = new Sin(mymap[15][14]);
		palya.addToMap(mymap[14][14]);
		mymap[13][14] = new Sin(mymap[14][14]);
		palya.addToMap(mymap[13][14]);
		mymap[12][14] = new Sin(mymap[13][14]);
		palya.addToMap(mymap[12][14]);
		mymap[11][14] = new Sin(mymap[12][14]);
		palya.addToMap(mymap[11][14]);
		mymap[10][14] = new Sin(mymap[11][14]);
		palya.addToMap(mymap[10][14]);
		mymap[10][13] = new Sin(mymap[10][14]);
		palya.addToMap(mymap[10][13]);
		mymap[10][12] = new Sin(mymap[10][13]);
		palya.addToMap(mymap[10][12]);
		mymap[10][11] = new Sin(mymap[10][12]);
		palya.addToMap(mymap[10][11]);
		mymap[10][11].setBPoint(mymap[10][10]);
		mymap[10][10].setAPoint(mymap[10][11]);
		
		Mozdony m = new Mozdony(mymap[10][10]);
		
		palya.addToEng(m);
		view.addTrain(m);
	
		return mymap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Hajaj... :/
		/*if(e.getActionCommand().equals("MENU_CREATED")){
			try {
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vezerlo.dat"));
	            jatek = (Jatek)ois.readObject();
	            view = (View)ois.readObject();
	            ois.close();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        }
		}
		
		
		if(e.getActionCommand().equals("MENU_CLOSED")){
			try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("vezerlo.dat"));
                oos.writeObject(jatek);
                oos.writeObject(view);
                oos.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
		}*/
	}

	public Jatek getJatek(){
		return jatek;
	}
}
