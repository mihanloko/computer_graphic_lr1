package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

public class Translation implements Multiplier {
    private static final int delta = 5;

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
                matrix[3][0] = delta;
                break;
            case OYPlus:
                matrix[3][1] = delta;
                break;
            case OZPlus:
                matrix[3][2] = delta;
                break;
            case OXMinus:
                matrix[3][0] = -delta;
                break;
            case OYMinus:
                matrix[3][1] = -delta;
                break;
            case OZMinus:
                matrix[3][2] = -delta;
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
