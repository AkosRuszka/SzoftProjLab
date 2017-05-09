package vasut;

import vasut.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import graph.*;


public class Keret {
public static void main(String[] args) throws Exception {	
		
		Vezerlo vez = null;
		
		try {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vezerlo.dat"));
	        vez = (Vezerlo)ois.readObject();
	        ois.close();
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }
		
		
		if(vez==null){
			Jatek j = new Jatek();
			View v = new View();
			Menu m = new Menu(j);
			
			vez = new Vezerlo(v, m, j);
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
