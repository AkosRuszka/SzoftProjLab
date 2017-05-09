package graph;

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
	
	public KocsiRajzolo(ImageIcon print_img, Point coord, Kocsi kocsi, Insets frameinsets) {
		this.kocsi = kocsi;
		this.print_img = print_img;
		this.notempty_img = print_img;
		this.empty_img = new ImageIcon("\\img\\kocsi_szurke.png");;
		this.coord = coord;
	}

	public void setFullImage(boolean b){
		if(b){//tele
			print_img = notempty_img;
		}
		else{
			print_img = empty_img;
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
