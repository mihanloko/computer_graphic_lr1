package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

public class Reflection implements Multiplier {
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
            case OX_MINUS:
                matrix[0][0] = -1;
                break;
            case OY_PLUS:
            case OY_MINUS:
                matrix[1][1] = -1;
                break;
            case OZ_PLUS:
            case OZ_MINUS:
                matrix[2][2] = -1;
                break;
        }

        for (MyPoint myPoint : myPoints) {
            myPoint.changeCoordinates(matrix);
        }
    }
}
