package A10_DijkstraPQShortestPath;
import java.util.List;

public class DijkstraPQShortestPath extends FindWay {
	private int[] dist;

	public DijkstraPQShortestPath(Graph graph) {
		super(graph);
	}
	
	/**
	 * Startentfernung initialisieren
	 * @param from Startknoten
	 */
	protected void initPathSearch() {
		int numv = graph.numVertices();
		dist = new int[numv];
		for (int i=0; i < numv; i++) {
			dist[i] = 9999;		// Summen im Graph d�rfen nie mehr ergeben
		}
	}
	
	/**
	 * Berechnet *alle* k�rzesten Wege ausgehend vom Startknoten
	 * Setzt dist[]- und pred[]-Arrays, kein R�ckgabewert
	 * @param from Startknoten
	 */
	protected boolean calculatePath(int from, int to) {

		return false;
	}
}
