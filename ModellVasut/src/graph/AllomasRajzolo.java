package graph;

import vasut.Allomas;

import java.awt.Dimension;
import java.awt.Image;
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
	
	public AllomasRajzolo(Point co, Allomas al, Insets fr, JLabel ny) {
		
		coord = co;
		allomas = al;
		insets = fr;
		nyillabel = ny;
		
		/* Kép beállítása a allomas színétől függően */
		try{
			switch(allomas.getColor().toUpperCase()) {
			case "YELLOW":
				allomasimg = new ImageIcon(".\\img\\allomas_sarga.png");
				break;
			case "RED":
				allomasimg = new ImageIcon(".\\img\\allomas_piros.png");
				break;
			case "BLUE":
				allomasimg = new ImageIcon(".\\img\\allomas_kek.png");
				break;
			case "GREEN":
				allomasimg = new ImageIcon(".\\img\\allomas_zold.png");
				break;
			default:
				allomasimg = null;
				break;
			}
			
			/* 20x20-as átméretezés */
			Image resizedImage = allomasimg.getImage();
			Image newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			allomasimg = new ImageIcon(newimg);
			
			setIcon(allomasimg);
			
			Dimension size = getPreferredSize();
			setBounds((int)coord.getX() + insets.left, (int)coord.getY() + insets.top,
		             size.width, size.height);
			
		} catch (Exception e) {
			e.getMessage();
		}
		if(allomas.getRisers()!=null){
			/* Felszálló nyíl beállítása már az elején */
			try {
				switch(allomas.getRisers().toUpperCase()) {
				case "YELLOW":
					felszalloimg = new ImageIcon(".\\img\\nyil_sarga.png");
					break;
				case "RED":
					felszalloimg = new ImageIcon(".\\img\\nyil_piros.png");
					break;
				case "BLUE":
					felszalloimg = new ImageIcon(".\\img\\nyil_kek.png");
					break;
				case "GREEN":
					felszalloimg = new ImageIcon(".\\img\\nyil_zold.png");
					break;
				default:
					felszalloimg = null;
					break;
				}
				
				/* 20x20-as átméretezés */
				Image resizedImage = felszalloimg.getImage();
				Image newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
				felszalloimg = new ImageIcon(newimg);			
				nyillabel.setIcon(felszalloimg);
				
				Dimension size = getPreferredSize();
				/* Nyillabel elhelyezése saját koordinátától 2pixellel lentebb és jobbrább */
				nyillabel.setBounds((int)coord.getX() + 2 + insets.left , (int)coord.getY() + 2 + insets.top,
			             size.width, size.height);
				
			} catch (Exception e){
				e.getMessage();
			}			
		}
	}

	@Override
	public Object getObject() {
		return allomas;
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
				break;
			case "RED":
				felszalloimg = new ImageIcon("\\img\\nyil_piros.png");
				break;
			case "GREEN":
				felszalloimg = new ImageIcon("\\img\\nyil_zold.png");
				break;
			case "BLUE":
				felszalloimg = new ImageIcon("\\img\\nyil_kek.png");
				break;
			default:
				/* Ha nincs már felszálló akkor eltüntetjük a nyilat */
				nyillabel.setVisible(false);
				break;
				
			}
			
			/* 20x20-as átméretezés, csak akkor ha az előtte levő switch nem a default-ba lépett.*/
			if(nyillabel.isVisible()){
				Image resizedImage = felszalloimg.getImage();
				Image newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
				felszalloimg = new ImageIcon(newimg);
				nyillabel.setIcon(felszalloimg);
			}
			
		}
	}

}
