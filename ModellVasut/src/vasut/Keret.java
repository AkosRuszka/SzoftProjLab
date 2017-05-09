package vasut;

import vasut.*;
import graph.*;

public class Keret {
public static void main(String[] args) throws Exception {
		Jatek j = new Jatek();
		View v = new View();
		Menu m = new Menu(j);
		Vezerlo vez = new Vezerlo(v,m,j);
		//event----------------------------------
		RailEvent re = new RailEvent(j, 2, vez);
		re.fire();
		//endevent-------------------------------
	}
}
