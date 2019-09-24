package projectPack1;

public class Edges {

	String source;
	String end;
	int cost;
	
	public Edges(String source, String end, int cost) {
		this.source = source;
		this.end = end;
		this.cost = cost;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getEnd() {
		return end;
	}
	
	public int getCost() {
		return cost;
	}

}
