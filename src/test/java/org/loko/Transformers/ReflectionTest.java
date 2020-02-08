package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;


public class ReflectionTest {

    @Test
    public void transform() {
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

        double delta = 0;
        double eps = 0.0001;
        double[] coordinates = myPoint.getCoordinates();

        assertTrue(delta < eps);

        /*RealMatrix matrix1 = new Array2DRowRealMatrix(new double[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}});
        RealMatrix matrix2 = new Array2DRowRealMatrix(new double[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}});
        RealMatrix result = matrix1.multiply(matrix2);
        System.out.println(result.toString());*/
    }
}