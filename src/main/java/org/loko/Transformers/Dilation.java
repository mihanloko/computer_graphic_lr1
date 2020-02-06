package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;
import org.loko.Transformers.Transformer;

import java.util.LinkedList;

public class Dilation implements Transformer {
    private static final double factorPlus = 1.05;
    private static final double factorMinus = 1.0 / factorPlus;

    @Override
    public void transform(LinkedList<MyPoint> myPoints, Directions direction) {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        switch (direction) {
            case OXPlus:
                matrix[0][0] = factorPlus;
                break;
            case OYPlus:
                matrix[1][1] = factorPlus;
                break;
            case OZPlus:
                matrix[2][2] = factorPlus;
                break;
            case OXMinus:
                matrix[0][0] = factorMinus;
                break;
            case OYMinus:
                matrix[1][1] = factorMinus;
                break;
            case OZMinus:
                matrix[2][2] = factorMinus;
                break;
        }

        for (MyPoint myPoint : myPoints) {
            myPoint.changeCoordinates(matrix);
        }
    }

    void customDilation(LinkedList<MyPoint> myPoints, double factor) {
        double[][] matrix = {
                {factor, 0, 0 , 0},
                {0, factor, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        for (MyPoint myPoint : myPoints) {
            myPoint.changeCoordinates(matrix);
        }
    }
}
