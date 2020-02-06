package Transformers;

import Picture.Point;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionTest {

    @Test
    public void transform() {
        double[][] matrix = {
                {-1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Reflection reflection = new Reflection();
        Point point = new Point(1, 2, 3);
        LinkedList<Point> points = new LinkedList<>();
        points.add(point);
        reflection.transform(points, Directions.OXPlus);
        RealMatrix transformMatrix = new Array2DRowRealMatrix(matrix);
        RealMatrix pointMatrix = new Array2DRowRealMatrix(new double[][]{{1}, {2}, {3}, {1}});
        RealMatrix result = transformMatrix.multiply(pointMatrix);
        double delta = 0;
        double eps = 0.0001;
        double[] coordinates = point.getCoordinates();
        for (int i = 0; i < 4; i++) {
            delta += Math.abs(coordinates[i] - result.getEntry(i, 0));
        }
        assertTrue(delta < eps);
        /*RealMatrix matrix1 = new Array2DRowRealMatrix(new double[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}});
        RealMatrix matrix2 = new Array2DRowRealMatrix(new double[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}});
        RealMatrix result = matrix1.multiply(matrix2);
        System.out.println(result.toString());*/
    }
}