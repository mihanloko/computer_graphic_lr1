package org.loko.Picture;

public class Edge {
    private MyPoint a, b;

    public Edge(MyPoint a, MyPoint b) {
        this.a = a;
        this.b = b;
    }

    public MyPoint getA() {
        return a;
    }

    public MyPoint getB() {
        return b;
    }
}
