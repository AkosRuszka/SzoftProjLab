package graph;

import java.awt.Image;
import java.awt.Point;

import vasut.Allomas;
import vasut.Sin;

public class SinRajzolo implements IRajzolo{
	private Sin sin;
	private Image img;
	private Point coord;
	public boolean visible;
	
	public SinRajzolo(Image img, Point coord, Allomas sin) {
		this.img = img;
		this.coord = coord;
		this.sin = sin;
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
		return sin;
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
