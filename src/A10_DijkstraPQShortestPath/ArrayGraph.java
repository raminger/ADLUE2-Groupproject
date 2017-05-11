package A10_DijkstraPQShortestPath;
import java.util.ArrayList;
import java.util.List;


public class ArrayGraph implements Graph {

	private int[][] graph;
	private int numVertices;
	private boolean directed;
	
	List<WeightedEdge> weList;
	
	public ArrayGraph(int numVertices, boolean directed) {
		graph = new int[numVertices][numVertices];
		this.numVertices = numVertices;
		this.directed = directed;
		weList = new ArrayList<WeightedEdge>();
	}
	
	public int numVertices() {
		return numVertices;
	}

	public boolean isDirected() {
		return directed;
	}

	public boolean hasEdge(int u, int v) {
		return (graph[u][v] > 0);
	}

	public int getEdgeWeight(int u, int v) {
		return graph[u][v];
	}

	public void addEdge(int u, int v) {
		addEdge(u, v, 1);
	}
	
	public void addEdge(int u, int v, int weight) {
		// TODO
		graph[u][v] = weight;
	}

	public void removeEdge(int u, int v) {
		graph[u][v] = 0;
	}

	public List<WeightedEdge> getEdges(int v) {
		// TODO
		List<WeightedEdge> resultEdges = new ArrayList<WeightedEdge>();
		for (WeightedEdge edge : weList) {
			if (edge.getTo_vertex() == v) {
				resultEdges.add(edge);
			}
		}
		return resultEdges;
	}
}
