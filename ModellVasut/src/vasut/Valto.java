package vasut;

public class Valto extends Sin{

	public Valto(Sin aPoint_) {
		super(aPoint_);
	}
	
	public int getActState(){
		System.out.println("Valto.getActState()");
		return 0;
	}
	
	public void nextState(){
		System.out.println("Valto.nextState())");
	}
	
	public void addConnectPoints(Sin a){
		System.out.println("Valto.addConnectPoints(Sin a)");
	}
}