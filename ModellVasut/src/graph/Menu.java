package graph;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vasut.Jatek;

public class Menu extends JFrame{
	private Jatek jatek; 
	
	private JButton bnewGame;
	private JButton bmapLoad;
	private JButton bnextMap;
	private JButton bsugo;
	private JPanel panel;
	private String sugo_string;
	
	protected ArrayList<ActionListener> list = new ArrayList<ActionListener>();
	
	public Menu(Jatek j){
		sugo_string = "Egyszer itt volt egy tök jó kis szöveg... csak elfelejtettem lementeni -.-";
		initComponents();
		jatek = j;
		
		/* Event jelzés */
		for(ActionListener act : list) {
			act.actionPerformed(new ActionEvent(this,8,"MENU_CREATED"));
		}

        // Bezáráskor jelezzük, hogy az adatokat szerializálni kell
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	/* Event jelzés */
    			for(ActionListener act : list) {
    				act.actionPerformed(new ActionEvent(this,8,"MENU_CLOSED"));
    			}
            }
        });
	}
	
	
	/** Listenerek felvétele */
	public void addActionListener(ActionListener listener) {
		list.add(listener);
	}
	
	private void initComponents(){
		this.setTitle("Vasút modell");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		bnewGame = new JButton("Új játék");
		bnewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		bnewGame.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  jatek.newGame();
			  }
		});
		bmapLoad = new JButton("Pálya betöltése");
		bmapLoad.setAlignmentX(Component.CENTER_ALIGNMENT);
		bmapLoad.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  jatek.mapLoad();
			  }
		});
		
		bnextMap = new JButton("Következő pálya betöltése");
		bnextMap.setAlignmentX(Component.CENTER_ALIGNMENT);
		bnextMap.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  jatek.nextMap();
			  }
		});
		
		bsugo = new JButton("Súgó");
		bsugo.setAlignmentX(Component.CENTER_ALIGNMENT);
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
		
		this.setSize(500, 230);
		this.setResizable(false);
		
		this.add(panel, BorderLayout.CENTER);		
	}
}
