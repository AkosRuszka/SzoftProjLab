package graph;

import java.util.ArrayList;
import graph.*;
import vasut.Mozdony;
import vasut.Palya;
import vasut.Sin;

public class View {
	ArrayList<IRajzolo> railElements = new ArrayList<IRajzolo>();
	ArrayList<IRajzolo> trainElements = new ArrayList<IRajzolo>();
	public void mapRedraw(){
		for(IRajzolo rail : railElements){
			
		}
	}
	
	public void newMapDraw(Palya actMap){
		for(Sin s : actMap.getMap()){
			//meh na ide kérek segítséget hogy rakom ki az elemeket
		}
		for(Mozdony s : actMap.getEngines()){
			//itt minden vonatnak kéne csinálni egy rajoltat :D 
		}
	}
}
