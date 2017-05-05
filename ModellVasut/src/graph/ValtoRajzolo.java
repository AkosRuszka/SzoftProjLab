package graph;

import vasut.Valto;

import java.awt.Image;
import java.awt.Point;

public class ValtoRajzolo implements IRajzolo{
	private Valto valto;
	private Image img;
	private Point coord;
	public boolean visible;
	
	public ValtoRajzolo(Image img, Point coord, Valto valto) {
		/* Koordináta és kép beállítása */
		this.img = img;
		this.coord = coord;
		this.valto = valto;
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

}
