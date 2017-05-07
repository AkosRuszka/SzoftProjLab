package graph;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vasut.Jatek;

public class Menu extends JFrame{
	private Jatek jatek = new Jatek(); 
	
	private JButton bnewGame;
	private JButton bmapLoad;
	private JButton bnextMap;
	private JButton bsugo;
	private JPanel panel;
	private String sugo_string;
	
	public Menu(){
		sugo_string = "Bla-bla... wip";
		initComponents();
	}
	
	private void initComponents(){
		this.setTitle("Vasút modell");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		bnewGame = new JButton("Új játék");
		bnewGame.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  jatek.newGame();
			  }
		});
		bmapLoad = new JButton("Pálya betöltése");
		bmapLoad.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  jatek.mapLoad();
			  }
		});
		
		bnextMap = new JButton("Következő pálya betöltése");
		bnextMap.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  jatek.nextMap();
			  }
		});
		
		bsugo = new JButton("Súgó");
		bsugo.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JOptionPane.showMessageDialog(null, sugo_string, "Súgó", JOptionPane.INFORMATION_MESSAGE);
			  }
		});
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(bnewGame);
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(bmapLoad);
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(bnextMap);
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(bsugo);
		
		this.add(panel, BorderLayout.CENTER);		
	}
}
