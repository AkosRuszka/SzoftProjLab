package graph;

import java.util.EventListener;
import java.util.EventObject;
import graph.*;

public class RailEvent extends EventObject{
	private Vezerlo myListener = null;
	private int id;
	public RailEvent(Object sent, int sid, EventListener listener) {
		super(sent);
		id = sid;
		myListener = (Vezerlo) listener;
	}
	public void fire(){
		myListener.EventOccurred(this);
	}
	public int getID(){
		return id;
	}	
}
