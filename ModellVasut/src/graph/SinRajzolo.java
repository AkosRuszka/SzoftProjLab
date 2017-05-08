package graph;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vasut.Allomas;
import vasut.Sin;

public class SinRajzolo implements IRajzolo, ActionListener{
	private Sin sin;
	private Image active_img;
	private Image inactive_img;
	private Image kereszt_image;
	private Image paint_img;
	private Point coord;
	public boolean visible;
	
	public SinRajzolo(Image actimg, Image inactimg , Image keresztimg, Point coord, Allomas sin) {
		this.active_img = actimg;
		this.inactive_img = inactimg;
		this.coord = coord;
		this.sin = sin;
		this.paint_img = actimg;
		this.kereszt_image = keresztimg;
		
		/* Feliratkozunk az sin eseményére */
		this.sin.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "INACTIVE":
			/* AP/BP_INACTIVE */
			paint_img = inactive_img;
			break;
		case "ACTIVE":
			/* AP/BP_ACTIVE */
			paint_img = active_img;
			break;
		case "CROSSING":
			/* setCrossing-nál... */
			paint_img = kereszt_image;
			break;
		}
	}

}
