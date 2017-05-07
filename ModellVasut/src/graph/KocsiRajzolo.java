package graph;

import java.awt.Image;
import java.awt.Point;

public class KocsiRajzolo implements IRajzolo {

	protected Image img;		// A Kocsit ábrázoló képfájl.
	private Point coord;		// A grafikus objektum x, y koordinátái.
	private boolean visible;	// A megjelenésért felelős.
	
	public KocsiRajzolo(Image img_, Point coord_)
	{
		img = img_;
		coord = coord_;
	}
	public void rajzol()		// Az objektum újrarajzolása a grafikus felületen.
	{
		//TODO 
	}
	public Point getCoord()		// A koordináták lekérdezése.
	{
		return coord;
	}
	public void setCoord(Point coord_)	// A koordináták beállítása.
	{
		coord = coord_;
	}
	public Object getObject()	// Az általa ismert objektum visszaadása vizsgálatra.
	{
		return this;
	}
}