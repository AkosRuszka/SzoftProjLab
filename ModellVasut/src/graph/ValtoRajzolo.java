package graph;

import vasut.Valto;

import java.awt.Dimension;
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
		
		try{
			this.img = new ImageIcon("\\img\\valto.png");
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
