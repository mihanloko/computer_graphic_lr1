package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;


public class ReflectionTest {

    @Test
    public void transformOX() {
        double[][] matrix = {
                {-1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Reflection reflection = new Reflection();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        reflection.transform(myPoints, Directions.OXPlus);
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
    public void transformOY() {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, -1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Reflection reflection = new Reflection();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        reflection.transform(myPoints, Directions.OYPlus);
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
    public void transformOZ() {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, -1, 0},
                {0, 0, 0, 1}
        };
        Reflection reflection = new Reflection();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        reflection.transform(myPoints, Directions.OZPlus);
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