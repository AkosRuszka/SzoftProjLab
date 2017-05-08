package graph;

import java.awt.Image;
import java.awt.Point;

import vasut.Kocsi;

public class KocsiRajzolo implements IRajzolo{
	private Kocsi kocsi;
	private Image img;
	private Point coord;
	public boolean visible;
	
	public KocsiRajzolo(Image img, Point coord, Kocsi kocsi) {
		this.kocsi = kocsi;
		this.img = img;
		this.coord = coord;
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
}
