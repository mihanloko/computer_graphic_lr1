public class Edge {
    private Point a, b;

    public Edge(Point a, Point b) {
        this.a = a;
        this.b = b;
//        System.out.println(a + " " + b);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }
}
