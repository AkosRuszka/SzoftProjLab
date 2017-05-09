package vasut;

import vasut.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import graph.*;


public class Keret {
public static void main(String[] args) throws Exception {	
		//Jatek j = new Jatek();
		//View v = new View();
		//Menu m = new Menu(j);
		Vezerlo vez = null;
		
		try {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vezerlo.dat"));
	        vez = (Vezerlo)ois.readObject();
	        ois.close();
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }
		
		
		
		//event----------------------------------
		RailEvent re = new RailEvent(vez.getJatek(), 2, vez);
		re.fire();
		//endevent-------------------------------
		
		try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("vezerlo.dat"));
            oos.writeObject(vez);
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
	}
}
