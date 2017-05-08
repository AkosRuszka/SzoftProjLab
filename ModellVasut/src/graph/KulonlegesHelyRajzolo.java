package graph;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import vasut.KulonlegesHely;

public class KulonlegesHelyRajzolo extends JButton implements IRajzolo{
	private KulonlegesHely kh;
	private Image img;
	private Point coord;
	
	public KulonlegesHelyRajzolo(Image img, Point coord, KulonlegesHely kh) {
		
		setLocation(coord);
		setIcon(new ImageIcon(img));
		
		addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  kh.checkTunnels();
			  }
		});
		
		this.kh = kh;
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
		// TODO Hajaj... :D
		
	}

	@Override
	public Object getObject() {
		return kh;
	}


	@Override
	public Point getPoint() {
		return coord;
	}


	@Override
	public void setPoint(Point point) {
		coord = point;
	}
}
