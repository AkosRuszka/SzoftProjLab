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
	
	public KocsiRajzolo(ImageIcon empty, ImageIcon notempty, Point coord, Kocsi kocsi, Insets frameinsets) {
		this.kocsi = kocsi;
		this.insets = frameinsets;
		this.print_img = notempty;
		this.notempty_img = notempty;
		this.empty_img = empty;
		this.coord = coord;
		
		try{
			setIcon(print_img);
		}
		catch (Exception e) {
			e.getMessage();
		}
		
		Dimension size = getPreferredSize();
		setBounds((int)coord.getX() + insets.left, (int)coord.getY() + insets.top,
	             size.width, size.height);
	}

	public void setFullImage(boolean b){
		if(b){//tele
			print_img = notempty_img;
		}
		else{
			print_img = empty_img;
		}
		try{
			setIcon(print_img);
		}
		catch (Exception e) {
			e.getMessage();
		}
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
		else //IDE KÉNE EGY EVENT, CSAK NINCS A KOCSIBA MÁSHONNAN KELL HA KIÜRÜLT
			print_img = empty_img;		
	}
}
