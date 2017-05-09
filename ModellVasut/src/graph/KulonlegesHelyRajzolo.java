package graph;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import vasut.KulonlegesHely;

public class KulonlegesHelyRajzolo extends JButton implements IRajzolo, ActionListener{
	private KulonlegesHely kh;
	private Image img_kh;
	private Image img_alagut;
	private Image paint_img;
	private Point coord;
	
	public KulonlegesHelyRajzolo(Image img_kh, Image img_a, Point coord, KulonlegesHely kh) {
		
		setLocation(coord);
		setIcon(new ImageIcon(img_kh));		
		
		addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  kh.checkTunnels();
			  }
		});
		
		this.kh = kh;
		this.img_kh = img_kh;
		this.img_alagut = img_a;
		this.paint_img = img_kh;
		this.coord = coord;		
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


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("KH_TUNNEL_BUILD"))
			paint_img = img_alagut;
		if(e.getActionCommand().equals("KH_TUNNEL_DESTROY"))
			paint_img = img_kh;		
	}
}
