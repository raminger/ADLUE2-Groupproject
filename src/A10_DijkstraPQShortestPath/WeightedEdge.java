package A10_DijkstraPQShortestPath;

public class WeightedEdge {
	public int from_vertex;
	public int to_vertex;
	public int weight;

	public WeightedEdge(int from_vertex, int to_vertex, int weight) {
		this.from_vertex = from_vertex;
		this.to_vertex = to_vertex;
		this.weight = weight;
	}

	public WeightedEdge(int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public int getFrom_vertex() {
		return from_vertex;
	}

	public void setFrom_vertex(int from_vertex) {
		this.from_vertex = from_vertex;
	}

	public int getTo_vertex() {
		return to_vertex;
	}

	public void setTo_vertex(int to_vertex) {
		this.to_vertex = to_vertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}	
}

