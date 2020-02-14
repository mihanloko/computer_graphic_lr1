package org.loko.Transformers;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;
import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TranslationTest {
    private static final int delta = 5;

    @Test
    void transform() {
        double[][] matrix = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        matrix[3][0] = delta;

        Multiplier reflection = new Translation();
        MyPoint myPoint = new MyPoint(1, 2, 3);
        LinkedList<MyPoint> myPoints = new LinkedList<>();
        myPoints.add(myPoint);
        reflection.transform(myPoints, Directions.OXPlus);
        RealMatrix transformMatrix = new Array2DRowRealMatrix(matrix);
        RealMatrix pointMatrix = new Array2DRowRealMatrix(new double[][]{{1}, {2}, {3}, {1}});
        RealMatrix result = transformMatrix.multiply(pointMatrix);
        double d = 0;
        double eps = 0.0001;
        double[] coordinates = myPoint.getCoordinates();
        for (int i = 0; i < 3; i++) {// при этом преобразовании вроде последняя координата не нужна. или во всех
            d += Math.abs(coordinates[i] - result.getEntry(i, 0));
        }
        assertTrue(d < eps);
    }

    @Test
    void customTranslation() {
    }
}