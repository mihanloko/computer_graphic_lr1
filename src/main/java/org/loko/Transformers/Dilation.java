package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

public class Dilation implements Multiplier {
    private static final double FACTOR_PLUS = 1.05;
    private static final double FACTOR_MINUS = 1.0 / FACTOR_PLUS;

    @Override
    public void transform(LinkedList<MyPoint> myPoints, Directions direction) {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        switch (direction) {
            case OX_PLUS:
                matrix[0][0] = FACTOR_PLUS;
                break;
            case OY_PLUS:
                matrix[1][1] = FACTOR_PLUS;
                break;
            case OZ_PLUS:
                matrix[2][2] = FACTOR_PLUS;
                break;
            case OX_MINUS:
                matrix[0][0] = FACTOR_MINUS;
                break;
            case OY_MINUS:
                matrix[1][1] = FACTOR_MINUS;
                break;
            case OZ_MINUS:
                matrix[2][2] = FACTOR_MINUS;
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
