package graph;

import vasut.Valto;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ValtoRajzolo extends JButton implements IRajzolo{
	private Valto valto;
	private ImageIcon img;
	private Point coord;
	private Insets insets;
	
	public ValtoRajzolo(Point coord, Valto valto, Insets frameinsets) {
		this.valto = valto;
		this.coord = coord;
		this.insets = frameinsets;
		
		setSize(new Dimension(20,20));
		setMaximumSize(getSize());
		setPreferredSize(new Dimension(20,20));
		
		try{
			this.img = new ImageIcon("\\img\\valto.png");
			
			// 20x20-as átméretezés
			Image resizedImage = img.getImage();
			Image newimg = resizedImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			img = new ImageIcon(newimg);
			
			setIcon(img);
		} catch(Exception e) {
			e.getMessage();
		}
		
		Dimension size = getPreferredSize();
		setBounds((int)coord.getX() + insets.left, (int)coord.getY() + insets.top,
	             size.width, size.height);
		
		/* kattintásra valto nextState() hívás */
		addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  valto.nextState();
			  }
		});		
	}

	@Override
	public Object getObject() {
		return valto;
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
}
