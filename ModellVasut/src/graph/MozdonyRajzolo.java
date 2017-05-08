package graph;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vasut.Mozdony;

public class MozdonyRajzolo implements IRajzolo, ActionListener{
	private Mozdony mozdony;
	private Image print_img;
	private Point coord;
	public boolean visible;
	
	public MozdonyRajzolo(Image img, Point coord, Mozdony m) {
		this.print_img = img;
		this.coord = coord;
		this.mozdony = m;
		visible = true;
	}

	public Point getCoord() {
		return coord;
	}

	public void setCoord(Point coord) {
		this.coord = coord;
	}

	@Override
	public void rajzol() {
		/* TODO: logika */
		
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("MOZDONY_MOVED")){
			//?
		}
		
	}
}
