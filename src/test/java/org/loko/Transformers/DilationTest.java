package org.loko.Transformers;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;
import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DilationTest {
    private static final double factorPlus = 1.05;
    private static final double customFactor = 1.5;
    private static final double factorMinus = 1.0 / factorPlus;

    @Test
    void transformOXPlus() {
        double[][] matrix = {
                {factorPlus, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Dilation dilation = new Dilation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        dilation.transform(myPoints, Directions.OXPlus);

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
                {factorMinus, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Dilation dilation = new Dilation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        dilation.transform(myPoints, Directions.OXMinus);

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
                {0, factorPlus, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Dilation dilation = new Dilation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        dilation.transform(myPoints, Directions.OYPlus);

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
                {0, factorMinus, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Dilation dilation = new Dilation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        dilation.transform(myPoints, Directions.OYMinus);

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
                {0, 0, factorPlus, 0},
                {0, 0, 0, 1}
        };
        Dilation dilation = new Dilation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        dilation.transform(myPoints, Directions.OZPlus);

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
                {0, 0, factorMinus, 0},
                {0, 0, 0, 1}
        };
        Dilation dilation = new Dilation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        dilation.transform(myPoints, Directions.OZMinus);

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
    void customDilation() {
        double[][] matrix = {
                {customFactor, 0, 0 , 0},
                {0, customFactor, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Dilation dilation = new Dilation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        dilation.customDilation(myPoints, customFactor);

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