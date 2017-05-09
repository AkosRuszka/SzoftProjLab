package graph;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vasut.Kocsi;

public class KocsiRajzolo implements IRajzolo, ActionListener{
	private Kocsi kocsi;
	private Image print_img;
	private Image empty_img;
	private Image notempty_img;
	private Point coord;
	
	public KocsiRajzolo(Image print_img, Image empty_img, Image notempty_img, Point coord, Kocsi kocsi) {
		this.kocsi = kocsi;
		this.print_img = notempty_img;
		this.notempty_img = notempty_img;
		this.empty_img = empty_img;
		this.coord = coord;
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
