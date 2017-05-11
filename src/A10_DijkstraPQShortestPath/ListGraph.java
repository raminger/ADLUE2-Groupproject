package A10_DijkstraPQShortestPath;
import java.util.ArrayList;
import java.util.List;

import A10_DijkstraPQShortestPath.WeightedEdge;

public class ListGraph implements Graph {

	private ArrayList<WeightedEdge>[] graph;
	private int numVertices;
	private boolean directed;
	
	
	@SuppressWarnings("unchecked")
	public ListGraph(int numVertices, boolean directed) 
	{
		this.numVertices = numVertices;
		this.directed = directed;
	//Create Arraylist
		graph = new ArrayList[numVertices];
		//Create ArrayList in each Array position to get a 2D Array
		for (int i=0; i < numVertices; i++)
			graph[i] = new ArrayList<WeightedEdge>();
		
	}
		
	public int numVertices() {
		return numVertices;
	}
	
	public boolean isDirected() {
		return directed;
	}

	public boolean hasEdge(int u, int v) {
		WeightedEdge pv = findEdge(u, v);
		return pv != null;
	}

	public int getEdgeWeight(int u, int v) {
		WeightedEdge pv = findEdge(u, v);
		return pv.weight;
	}

	public void addEdge(int u, int v) {
		addEdge(u, v, 1);
	}
	
	public void addEdge(int u, int v, int weight) {
		graph[u].add(new WeightedEdge(u, v, weight));
		if (!directed) {
			graph[v].add(new WeightedEdge(v, u, weight));
		}
	}
	
	private WeightedEdge findEdge(int u, int v) {
		for (WeightedEdge we: graph[u]) {
			if (we.to_vertex == v) {
				return we;
			}
		}
		return null;
	}

	public void removeEdge(int u, int v) {
		for (WeightedEdge we: graph[u]) {
			if (we.to_vertex == v) {
				graph[u].remove(v);
				break;
			}
		}
	}

	public List<WeightedEdge> getEdges(int v) {
		return graph[v];
	}
}
