package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

public class Translation implements Multiplier {
    private static final int DELTA = 5;

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
                matrix[3][0] = DELTA;
                break;
            case OY_PLUS:
                matrix[3][1] = DELTA;
                break;
            case OZ_PLUS:
                matrix[3][2] = DELTA;
                break;
            case OX_MINUS:
                matrix[3][0] = -DELTA;
                break;
            case OY_MINUS:
                matrix[3][1] = -DELTA;
                break;
            case OZ_MINUS:
                matrix[3][2] = -DELTA;
                break;
        }

        for (MyPoint myPoint : myPoints) {
            myPoint.changeCoordinates(matrix);
        }
    }

    void customTranslation(LinkedList<MyPoint> myPoints, int x, int y) {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {x, y, 0, 1}
        };

        for (MyPoint myPoint : myPoints) {
            myPoint.changeCoordinates(matrix);
        }
    }
}
