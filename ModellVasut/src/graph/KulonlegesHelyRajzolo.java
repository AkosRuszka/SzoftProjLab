package graph;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import vasut.KulonlegesHely;

public class KulonlegesHelyRajzolo extends JButton implements IRajzolo, ActionListener{
	private KulonlegesHely kh;
	private Point coord;
	private Insets insets;
	
	private ImageIcon img_kh;
	private ImageIcon img_alagut;
	private ImageIcon paint_img;
	
	
	public KulonlegesHelyRajzolo(Point coord, KulonlegesHely kh, Insets frameinsets) {
		try{		
			this.img_kh = new ImageIcon(".\\img\\kulonlegeshely.png");
			this.img_alagut = new ImageIcon(".\\img\\alagut.png");
			this.paint_img = img_kh;	
		} catch (Exception e) {
			e.getMessage();
		}
		
		setSize(new Dimension(20,20));
		setMaximumSize(getSize());
		setPreferredSize(new Dimension(20,20));
		
		this.insets = frameinsets;
		this.kh = kh;
		this.coord = coord;
		
		/* 20x20-as átméretezés */
		Image resizedImage = paint_img.getImage();
		Image newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		paint_img = new ImageIcon(newimg);
		
		resizedImage = img_kh.getImage();
		newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		img_kh = new ImageIcon(newimg);
		
		resizedImage = img_alagut.getImage();
		newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		img_alagut = new ImageIcon(newimg);
		
		setIcon(paint_img);
		
		//Gomb esemény kezelője
		addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  kh.checkTunnels();
			  }
		});
		
		//Felíratkozunk a KülönlegesHely eseményeire
		this.kh.addActionListener(this);
		
		Dimension size = getPreferredSize();
		setBounds((int)coord.getX() + insets.left, (int)coord.getY() + insets.top, 	size.width, size.height);	
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
		/* Nem rakjuk arrébb a sin-t */
		//coord = point;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("KH_TUNNEL_BUILD"))
			paint_img = img_alagut;
		if(e.getActionCommand().equals("KH_TUNNEL_DESTROY"))
			paint_img = img_kh;		
		setIcon(paint_img);
	}
}
