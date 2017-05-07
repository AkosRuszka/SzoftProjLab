package graph;

import vasut.Valto;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ValtoRajzolo extends JButton implements IRajzolo{
	private Valto valto;
	private Image img;
	private Point coord;
	
	public ValtoRajzolo(Image img, Point coord, Valto valto) {
		/* Koordináta, kép, ActionListener beállítása */
		setLocation(coord);
		setIcon(new ImageIcon(img));
		
		addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  valto.nextState();
			  }
		});
		
		this.valto = valto;
		this.img = img;
		this.coord = coord;
		
	}

	
	public Point getCoord() {
		return coord;
	}

	public void setCoord(Point coord) {
		this.coord = coord;
	}

	@Override
	public void rajzol() {
		/* Kérdés mi kell ide... */
		
	}

	@Override
	public Object getObject() {
		return this;
	}
}
