package org.loko.Picture;

import java.util.LinkedList;

public class Picture {
    LinkedList<Edge> edges = new LinkedList<>();

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void addEdge(MyPoint a, MyPoint b) {
        edges.add(new Edge(a, b));
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }
}
