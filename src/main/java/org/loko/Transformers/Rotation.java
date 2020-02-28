package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

public class Rotation implements Multiplier {
    private static final double ALPHA = 0.0872665;

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
                matrix[1][1] = Math.cos(ALPHA);
                matrix[1][2] = Math.sin(ALPHA);
                matrix[2][1] = -Math.sin(ALPHA);
                matrix[2][2] = Math.cos(ALPHA);
                break;
            case OY_PLUS:
                matrix[0][0] = Math.cos(ALPHA);
                matrix[0][2] = -Math.sin(ALPHA);
                matrix[2][0] = Math.sin(ALPHA);
                matrix[2][2] = Math.cos(ALPHA);
                break;
            case OZ_PLUS:
                matrix[0][0] = Math.cos(ALPHA);
                matrix[0][1] = Math.sin(ALPHA);
                matrix[1][0] = -Math.sin(ALPHA);
                matrix[1][1] = Math.cos(ALPHA);
                break;
            case OX_MINUS:
                matrix[1][1] = Math.cos(-ALPHA);
                matrix[1][2] = Math.sin(-ALPHA);
                matrix[2][1] = -Math.sin(-ALPHA);
                matrix[2][2] = Math.cos(-ALPHA);
                break;
            case OY_MINUS:
                matrix[0][0] = Math.cos(-ALPHA);
                matrix[0][2] = -Math.sin(-ALPHA);
                matrix[2][0] = Math.sin(-ALPHA);
                matrix[2][2] = Math.cos(-ALPHA);
                break;
            case OZ_MINUS:
                matrix[0][0] = Math.cos(-ALPHA);
                matrix[0][1] = Math.sin(-ALPHA);
                matrix[1][0] = -Math.sin(-ALPHA);
                matrix[1][1] = Math.cos(-ALPHA);
                break;
        }

        for (MyPoint myPoint : myPoints) {
            myPoint.changeCoordinates(matrix);
        }
    }
}
