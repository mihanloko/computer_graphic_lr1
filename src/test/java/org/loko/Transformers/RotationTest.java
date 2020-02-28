package org.loko.Transformers;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;
import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class RotationTest {
    private static final double alpha = 0.0872665;

    @Test
    void transformOXPlus() {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        matrix[1][1] = Math.cos(alpha);
        matrix[1][2] = Math.sin(alpha);
        matrix[2][1] = -Math.sin(alpha);
        matrix[2][2] = Math.cos(alpha);

        Rotation reflection = new Rotation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        reflection.transform(myPoints, Directions.OX_PLUS);
        RealMatrix transformMatrix = new Array2DRowRealMatrix(matrix);
        RealMatrix pointMatrix = new Array2DRowRealMatrix(new double[][]{{1}, {2}, {3}, {1}});
        RealMatrix result = transformMatrix.multiply(pointMatrix);
        double delta = 0;
        double eps = 0.0001;
        double[] coordinates = myPoint.getCoordinates();
        for (int i = 0; i < 4; i++) {
            delta += Math.abs(coordinates[i] - result.getEntry(i, 0));
        }
        assertTrue(delta < eps);
    }

    @Test
    void transformOXMinus() {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        matrix[1][1] = Math.cos(-alpha);
        matrix[1][2] = Math.sin(-alpha);
        matrix[2][1] = -Math.sin(-alpha);
        matrix[2][2] = Math.cos(-alpha);

        Rotation reflection = new Rotation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        reflection.transform(myPoints, Directions.OX_MINUS);
        RealMatrix transformMatrix = new Array2DRowRealMatrix(matrix);
        RealMatrix pointMatrix = new Array2DRowRealMatrix(new double[][]{{1}, {2}, {3}, {1}});
        RealMatrix result = transformMatrix.multiply(pointMatrix);
        double delta = 0;
        double eps = 0.0001;
        double[] coordinates = myPoint.getCoordinates();
        for (int i = 0; i < 4; i++) {
            delta += Math.abs(coordinates[i] - result.getEntry(i, 0));
        }
        assertTrue(delta < eps);
    }

    @Test
    void transformOYPlus() {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        matrix[0][0] = Math.cos(alpha);
        matrix[0][2] = -Math.sin(alpha);
        matrix[2][0] = Math.sin(alpha);
        matrix[2][2] = Math.cos(alpha);

        Rotation reflection = new Rotation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        reflection.transform(myPoints, Directions.OY_PLUS);
        RealMatrix transformMatrix = new Array2DRowRealMatrix(matrix);
        RealMatrix pointMatrix = new Array2DRowRealMatrix(new double[][]{{1}, {2}, {3}, {1}});
        RealMatrix result = transformMatrix.multiply(pointMatrix);
        double delta = 0;
        double eps = 0.0001;
        double[] coordinates = myPoint.getCoordinates();
        for (int i = 0; i < 4; i++) {
            delta += Math.abs(coordinates[i] - result.getEntry(i, 0));
        }
        assertTrue(delta < eps);
    }

    @Test
    void transformOYMinus() {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        matrix[0][0] = Math.cos(-alpha);
        matrix[0][2] = -Math.sin(-alpha);
        matrix[2][0] = Math.sin(-alpha);
        matrix[2][2] = Math.cos(-alpha);

        Rotation reflection = new Rotation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        reflection.transform(myPoints, Directions.OY_MINUS);
        RealMatrix transformMatrix = new Array2DRowRealMatrix(matrix);
        RealMatrix pointMatrix = new Array2DRowRealMatrix(new double[][]{{1}, {2}, {3}, {1}});
        RealMatrix result = transformMatrix.multiply(pointMatrix);
        double delta = 0;
        double eps = 0.0001;
        double[] coordinates = myPoint.getCoordinates();
        for (int i = 0; i < 4; i++) {
            delta += Math.abs(coordinates[i] - result.getEntry(i, 0));
        }
        assertTrue(delta < eps);
    }

    @Test
    void transformOZPlus() {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        matrix[0][0] = Math.cos(alpha);
        matrix[0][1] = Math.sin(alpha);
        matrix[1][0] = -Math.sin(alpha);
        matrix[1][1] = Math.cos(alpha);

        Rotation reflection = new Rotation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        reflection.transform(myPoints, Directions.OZ_PLUS);
        RealMatrix transformMatrix = new Array2DRowRealMatrix(matrix);
        RealMatrix pointMatrix = new Array2DRowRealMatrix(new double[][]{{1}, {2}, {3}, {1}});
        RealMatrix result = transformMatrix.multiply(pointMatrix);
        double delta = 0;
        double eps = 0.0001;
        double[] coordinates = myPoint.getCoordinates();
        for (int i = 0; i < 4; i++) {
            delta += Math.abs(coordinates[i] - result.getEntry(i, 0));
        }
        assertTrue(delta < eps);
    }

    @Test
    void transformOZMinus() {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        matrix[0][0] = Math.cos(-alpha);
        matrix[0][1] = Math.sin(-alpha);
        matrix[1][0] = -Math.sin(-alpha);
        matrix[1][1] = Math.cos(-alpha);

        Rotation reflection = new Rotation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        reflection.transform(myPoints, Directions.OZ_MINUS);
        RealMatrix transformMatrix = new Array2DRowRealMatrix(matrix);
        RealMatrix pointMatrix = new Array2DRowRealMatrix(new double[][]{{1}, {2}, {3}, {1}});
        RealMatrix result = transformMatrix.multiply(pointMatrix);
        double delta = 0;
        double eps = 0.0001;
        double[] coordinates = myPoint.getCoordinates();
        for (int i = 0; i < 4; i++) {
            delta += Math.abs(coordinates[i] - result.getEntry(i, 0));
        }
        assertTrue(delta < eps);
    }

}