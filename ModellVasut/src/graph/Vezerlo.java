package graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import vasut.Jatek;
import vasut.Palya;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("MENU_CREATED")){
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
		}
	}
}
