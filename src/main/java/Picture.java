import java.util.LinkedList;

public class Picture {
    LinkedList<Edge> edges = new LinkedList<>();

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void addEdge(Point a, Point b) {
        edges.add(new Edge(a, b));
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }
}
