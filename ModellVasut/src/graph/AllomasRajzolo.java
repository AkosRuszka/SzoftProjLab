package graph;

import vasut.Allomas;

import java.awt.Image;
import java.awt.Point;

public class AllomasRajzolo implements IRajzolo{
	private Allomas allomas;
	private Image img;
	private Point coord;
	public boolean visible;
	
	public AllomasRajzolo(Image img, Point coord, Allomas allomas) {
		this.img = img;
		this.coord = coord;
		this.allomas = allomas;
	}

	public Point getCoord() {
		return coord;
	}

	public void setCoord(Point coord) {
		this.coord = coord;
	}

	@Override
	public void rajzol() {
		/* Kérdés mi kell ide... */
		
	}

	@Override
	public Object getObject() {
		return this;
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
