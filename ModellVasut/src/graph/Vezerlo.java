package graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import vasut.Jatek;
import vasut.Kezdopont;
import vasut.Mozdony;
import vasut.Palya;
import vasut.Sin;

public class Vezerlo implements ActionListener{
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
		
		mozdonykreate(getmap());			
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
	
	public Sin[][] getmap() {
		Sin mymap[][] = new Sin[30][30];
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				mymap[i][j] = null;
			}
		}
		
		mymap[10][10] = new Kezdopont(10,10,10,null);
		mymap[11][10] = new Sin(mymap[10][10]);
		mymap[12][10] = new Sin(mymap[11][10]);
		mymap[13][10] = new Sin(mymap[12][10]);
		mymap[14][10] = new Sin(mymap[13][10]);
		mymap[15][10] = new Sin(mymap[14][10]);
		mymap[16][10] = new Sin(mymap[15][10]);
		mymap[17][10] = new Sin(mymap[16][10]);
		mymap[17][11] = new Sin(mymap[17][10]);
		mymap[17][12] = new Sin(mymap[17][11]);
		mymap[17][13] = new Sin(mymap[17][12]);
		mymap[17][14] = new Sin(mymap[17][13]);
		mymap[16][14] = new Sin(mymap[17][14]);
		mymap[15][14] = new Sin(mymap[16][14]);
		mymap[14][14] = new Sin(mymap[15][14]);
		mymap[13][14] = new Sin(mymap[14][14]);
		mymap[12][14] = new Sin(mymap[13][14]);
		mymap[11][14] = new Sin(mymap[12][14]);
		mymap[10][14] = new Sin(mymap[11][14]);
		mymap[10][13] = new Sin(mymap[10][14]);
		mymap[10][12] = new Sin(mymap[10][13]);
		mymap[10][11] = new Sin(mymap[10][12]);
		mymap[10][10].setAPoint(mymap[10][11]);
		mymap[10][11].setBPoint(mymap[10][10]);
	
		this.view.mapfeldolgozas(mymap);
		this.jatek.mapatadas(mymap);
		
		return mymap;
	}
	
	public void mozdonykreate(Sin sin[][])
	{
		Mozdony mozdony = new Mozdony(sin[12][10]);
		this.view.vonathozzaadas(mozdony);
		this.jatek.vonataatadas(mozdony);
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
