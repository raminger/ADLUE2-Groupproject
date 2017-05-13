package A10_DijkstraPQShortestPath;

import java.util.List;

public class DijkstraPQShortestPath extends FindWay {
    private int[] dist;

    public DijkstraPQShortestPath(Graph graph) {
        super(graph);
    }

    /**
     * Startentfernung initialisieren
     */
    protected void initPathSearch() {
        int numv = graph.numVertices();
        super.pred = new int[numv];
        dist = new int[numv];

        for (int i = 0; i < numv; i++) {
            super.pred[i] = -1;
        }

        for (int i = 0; i < numv; i++) {
            dist[i] = 9999;        // Summen im Graph dürfen nie mehr ergeben
        }
    }

    /**
     * Berechnet *alle* kürzesten Wege ausgehend vom Startknoten
     * Setzt dist[]- und pred[]-Arrays, kein Rückgabewert
     *
     * @param from Startknoten
     */
    protected boolean calculatePath(int from, int to) {
        VertexHeap heap = new VertexHeap(graph.numVertices());

        for (int i = 0; i < graph.numVertices(); i++) {
            heap.insert(new Vertex(i, dist[i]));
        }

        super.pred[from] = -1;
        dist[from] = 0;
        heap.setCost(from, 0);

        while (!heap.isEmpty()) {
            Vertex cur = heap.remove();
            if (cur.vertex == to) return true;

            List<WeightedEdge> neighbours = graph.getEdges(cur.vertex);
            for (WeightedEdge neighbour : neighbours) {
                int sumDist = cur.cost + neighbour.weight;

                if (sumDist < dist[neighbour.to_vertex]) {
                    super.pred[neighbour.to_vertex] = cur.vertex;
                    dist[neighbour.to_vertex] = sumDist;
                    heap.setCost(neighbour.to_vertex, sumDist);
                }
            }
        }

        return (dist[to] != 9999);
    }
}
