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
	Jatek jatek = new Jatek(); 
	
	JButton newGame;
	JButton loadGame;
	JButton sugo;
	JPanel panel;
	String sugo_string;
	
	Menu(){
		sugo_string = "Bla-bla... wip";
		initComponents();
	}
	
	private void initComponents(){
		this.setTitle("Vasút modell");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		newGame = new JButton("Új játék");
		newGame.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  jatek.newGame();
			  }
		});
		loadGame = new JButton("Előző pálya betöltése");
		loadGame.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  jatek.mapLoad();
			  }
		});
		sugo = new JButton("Súgó");
		sugo.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JOptionPane.showMessageDialog(null, sugo_string, "Súgó", JOptionPane.INFORMATION_MESSAGE);
			  }
		});
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(newGame);
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(loadGame);
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(sugo);
		
		this.add(panel, BorderLayout.CENTER);		
	}
}
