package graph;

import vasut.Allomas;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AllomasRajzolo extends JLabel implements IRajzolo, ActionListener, Serializable{
	private ImageIcon allomasimg;
	private ImageIcon felszalloimg;
	private Insets insets;
	private JLabel nyillabel;
	private Point coord;
	
	private Allomas allomas;
	
	public AllomasRajzolo(Point coord, Allomas allomas, Insets frameinsets, JLabel nyillabel) {
		
		this.coord = coord;
		this.allomas = allomas;
		this.insets = insets;
		this.nyillabel = nyillabel;
		
		/* Kép beállítása a allomas színétől függően */
		try{
			switch(allomas.getColor().toUpperCase()) {
			case "YELLOW":
				allomasimg = new ImageIcon("\\img\\allomas_sarga.png");
				break;
			case "RED":
				allomasimg = new ImageIcon("\\img\\allomas_piros.png");
				break;
			case "BLUE":
				allomasimg = new ImageIcon("\\img\\allomas_kek.png");
				break;
			case "GREEN":
				allomasimg = new ImageIcon("\\img\\allomas_zold.png");
				break;
			}
			setIcon(allomasimg);
		} catch (Exception e) {
			e.getMessage();
		}
		
		/* Felszálló nyíl beállítása már az elején */
		try {
			switch(allomas.getRisers().toUpperCase()) {
			case "YELLOW":
				felszalloimg = new ImageIcon("\\img\\nyil_sarga.png");
				break;
			case "RED":
				felszalloimg = new ImageIcon("\\img\\nyil_piros.png");
				break;
			case "BLUE":
				felszalloimg = new ImageIcon("\\img\\nyil_kek.png");
				break;
			case "GREEN":
				felszalloimg = new ImageIcon("\\img\\nyil_zold.png");
				break;
			default:
				felszalloimg = null;
				break;
			}
			nyillabel.setIcon(felszalloimg);
		} catch (Exception e){
			e.getMessage();
		}
		
		Dimension size = getPreferredSize();
		setBounds((int)coord.getX() + insets.left, (int)coord.getY() + insets.top,
	             size.width, size.height);
		
		/* Nyillabel elhelyezése saját koordinátától 2pixellel lentebb és jobbrább */
		nyillabel.setBounds((int)coord.getX() + 2 + insets.left , (int)coord.getY() + 2 + insets.top,
	             size.width, size.height);
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
		/* Nem rakjuk arrébb a sin-t */
		//coord = point;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Ha felszállás történt az általunk ismert állomásra */
		if(e.getActionCommand().toUpperCase().equals("FELSZALLAS")) {
			/* Megtörtént a felszállás, képcsere kell */
			switch(allomas.getRisers().toUpperCase()) {
			case "YELLOW":
				felszalloimg = new ImageIcon("\\img\\nyil_sarga.png");
				nyillabel.setIcon(felszalloimg);
				break;
			case "RED":
				felszalloimg = new ImageIcon("\\img\\nyil_piros.png");
				nyillabel.setIcon(felszalloimg);
				break;
			case "GREEN":
				felszalloimg = new ImageIcon("\\img\\nyil_zold.png");
				nyillabel.setIcon(felszalloimg);
				break;
			case "BLUE":
				felszalloimg = new ImageIcon("\\img\\nyil_kek.png");
				nyillabel.setIcon(felszalloimg);
				break;
			default:
				/* Ha nincs már felszálló akkor eltüntetjük a nyilat */
				nyillabel.setVisible(false);
				break;
				
			}	
		}
	}

}
