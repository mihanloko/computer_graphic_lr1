import Picture.Edge;

public class Projection {
    private double f = 0.5;
    private double alpha = 0.785398;
    private double[][] matrix = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {-f * Math.cos(alpha), -f * Math.sin(alpha), 0, 0},
            {0, 0, 0, 1}};

    public Edge projectionOfEdge(Edge edge) {
        return new Edge(edge.getA().multiply(matrix),
                edge.getB().multiply(matrix));
    }
}
