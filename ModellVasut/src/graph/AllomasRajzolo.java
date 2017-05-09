package graph;

import vasut.Allomas;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllomasRajzolo implements IRajzolo, ActionListener{
	private Allomas allomas;
	private Image img;
	private Point coord;
	public boolean visible;
	
	public AllomasRajzolo(Image img, Point coord, Allomas allomas) {
		this.img = img;
		this.coord = coord;
		this.allomas = allomas;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Ha felszállás történt az általunk ismert állomásra */
		if(e.getActionCommand().equals("FELSZALLAS")) {
			/* Megtörtént a felszállás, képcsere kell */
			switch(allomas.getRisers()) {
			case "yellow":
				/* yellow image beállítása */
				break;
			case "red":
				/* red image beállítása */
				break;
			case "green":
				/* green image beállítása */
				break;
			case "blue":
				/* yellow image beállítása */
				break;
			}	
		}
	}

}
