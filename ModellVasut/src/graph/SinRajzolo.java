package graph;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vasut.Allomas;
import vasut.Sin;

public class SinRajzolo extends JLabel implements IRajzolo, ActionListener, Serializable{
	private ImageIcon active_img;
	private ImageIcon inactive_img;
	private ImageIcon kereszt_image;
	private ImageIcon paint_img;
	private Insets insets;
	private Point coord;
	
	private Sin sin;
	
	public SinRajzolo(Point coord, Sin sin, Insets frameinsets) {
		try {
			active_img = new ImageIcon(".\\img\\sin_zold.png");
			inactive_img = new ImageIcon(".\\img\\sin_piros.png");
			paint_img = new ImageIcon(".\\img\\sin.png");
			kereszt_image = new ImageIcon(".\\img\\keresztsin.png");
			
			// 20x20-as átméretezés
			Image resizedImage = active_img.getImage();
			Image newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			active_img = new ImageIcon(newimg);
			
			resizedImage = inactive_img.getImage();
			newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			inactive_img = new ImageIcon(newimg);
			
			resizedImage = paint_img.getImage();
			newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			paint_img = new ImageIcon(newimg);
			
			resizedImage = kereszt_image.getImage();
			newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			kereszt_image = new ImageIcon(newimg);
			
			setIcon(paint_img);
		} catch (Exception e) {
			e.getMessage();
		}
		
		this.insets = frameinsets;
		this.coord = coord;
		this.sin = sin;
		
		/* Feliratkozunk a sin eseményére */
		this.sin.addActionListener(this);
		
		Dimension size = getPreferredSize();
		setBounds((int)coord.getX() + insets.left, (int)coord.getY() + insets.top,
	             size.width, size.height);
		
		setVisible(true);
	}
	
	@Override
	public Object getObject() {
		return sin;
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
	
	public void rePainter(){
		Dimension size = getPreferredSize();
		setBounds((int)coord.getX() + insets.left, (int)coord.getY() + insets.top,
	             size.width, size.height);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand().toUpperCase()) {
		case "INACTIVE":
			/* AP/BP_INACTIVE */
			paint_img = inactive_img;
			break;
		case "ACTIVE":
			/* AP/BP_ACTIVE */
			paint_img = active_img;
			break;
		case "CROSSING":
			/* setCrossing-nál... */
			paint_img = kereszt_image;
			break;
		default:
			paint_img = null;
			break;
		}
		setIcon(paint_img);
	}
}
