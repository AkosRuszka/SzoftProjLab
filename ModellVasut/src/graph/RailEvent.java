package graph;

import java.util.EventObject;
import graph.*;

public class RailEvent extends EventObject{
	private Vezerlo myListener = new Vezerlo();
	private int id;
	public RailEvent(Object sent, int sid) {
		super(sent);
		id = sid;
	}
	public void fire(){
		myListener.EventOccurred(this);
	}
	public int getID(){
		return id;
	}	
}
