package org.loko;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;
import org.loko.Picture.Edge;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectionTest {

    private double f = 0.5;
    private double alpha = 0.785398;
    private double[][] matrix = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {-f * Math.cos(alpha), -f * Math.sin(alpha), 0, 0},
            {0, 0, 0, 1}};

    @Test
    void projectionOfEdge() {
        Projection projection = new Projection();
        MyPoint myPoint1 = new MyPoint(1, 2, 3);
        MyPoint myPoint2 = new MyPoint(4, 5, 6);
        Edge edge = new Edge(myPoint1, myPoint2);
        Edge result = projection.projectionOfEdge(edge);

        RealMatrix transformMatrix = new Array2DRowRealMatrix(matrix);
        RealMatrix pointMatrix1 = new Array2DRowRealMatrix(new double[][]{{1}, {2}, {3}, {1}});
        RealMatrix pointMatrix2 = new Array2DRowRealMatrix(new double[][]{{4}, {5}, {6}, {1}});
        RealMatrix resultMatrix1 = transformMatrix.multiply(pointMatrix1);
        RealMatrix resultMatrix2 = transformMatrix.multiply(pointMatrix2);

        double delta = 0;
        double eps = 0.0001;
        double[] coordinates = myPoint1.getCoordinates();
        for (int i = 0; i < 4; i++) {
            delta += Math.abs(coordinates[i] - resultMatrix1.getEntry(i, 0));
        }
        coordinates = myPoint2.getCoordinates();
        for (int i = 0; i < 4; i++) {
            delta += Math.abs(coordinates[i] - resultMatrix2.getEntry(i, 0));
        }
        assertTrue(delta < eps);
    }
}