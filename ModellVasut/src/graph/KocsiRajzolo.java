package graph;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vasut.Kocsi;

public class KocsiRajzolo extends JLabel implements IRajzolo, ActionListener{
	private Kocsi kocsi;
	private ImageIcon print_img;
	private ImageIcon empty_img;
	private ImageIcon notempty_img;
	private Point coord;
	private Insets insets;
	
	public KocsiRajzolo(Point coord, Kocsi kocsi, Insets frameinsets) {
		this.kocsi = kocsi;
		this.insets = frameinsets;
		this.coord = coord;
		
		try {
			switch(kocsi.getColor().toUpperCase()) {
			case "YELLOW":
				notempty_img = new ImageIcon("\\img\\kocsi_sarga.png");
				break;
			case "RED":
				notempty_img = new ImageIcon("\\img\\kocsi_piros.png");
				break;
			case "BLUE":
				notempty_img = new ImageIcon("\\img\\kocsi_kek.png");
				break;
			case "GREEN":
				notempty_img = new ImageIcon("\\img\\kocsi_zold.png");
				break;
			default:
				notempty_img = null;
				empty_img = null;
				break;
			}
			
			print_img = notempty_img;
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
		return kocsi;
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
		if(e.getActionCommand().equals("KOCSI_NOTEMPTY")){
			print_img = notempty_img;
		}
		else {
			print_img = empty_img;
		}
		setIcon(print_img);
	}
}
