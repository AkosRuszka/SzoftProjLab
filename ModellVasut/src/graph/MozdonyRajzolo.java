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

import vasut.Mozdony;

public class MozdonyRajzolo extends JLabel implements IRajzolo, Serializable {
	private Mozdony mozdony;
	private ImageIcon print_img;
	private Point coord;
	private Insets insets;
	
	public MozdonyRajzolo(Point coord, Mozdony m, Insets frameinsets) {
		this.coord = coord;
		this.mozdony = m;
		this.insets = frameinsets;
		
		
		/* 20x20-as átméretezés */
		
		try{
			this.print_img = new ImageIcon(".\\img.\\mozdony.png");
			Image resizedImage = print_img.getImage();
			Image newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			print_img = new ImageIcon(newimg);
			setIcon(print_img);
		}
		catch (Exception e) {
			e.getMessage();
		}
		
		
		
		
		Dimension size = getPreferredSize();
		setBounds((int)coord.getX() + insets.left, (int)coord.getY() + insets.top,
	             size.width, size.height);
	}

	@Override
	public Object getObject() {
		return mozdony;
	}

	@Override
	public Point getPoint() {
		return coord;
	}

	@Override
	public void setPoint(Point point) {
		coord = point;
		Dimension size = getPreferredSize();
		setBounds((int)coord.getX() + insets.left, (int)coord.getY() + insets.top,
	             size.width, size.height);
	}
}
