package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

public class Rotation implements Multiplier {
    private static final double alpha = 0.0872665;

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
                matrix[1][1] = Math.cos(alpha);
                matrix[1][2] = Math.sin(alpha);
                matrix[2][1] = -Math.sin(alpha);
                matrix[2][2] = Math.cos(alpha);
                break;
            case OYPlus:
                matrix[0][0] = Math.cos(alpha);
                matrix[0][2] = -Math.sin(alpha);
                matrix[2][0] = Math.sin(alpha);
                matrix[2][2] = Math.cos(alpha);
                break;
            case OZPlus:
                matrix[0][0] = Math.cos(alpha);
                matrix[0][1] = Math.sin(alpha);
                matrix[1][0] = -Math.sin(alpha);
                matrix[1][1] = Math.cos(alpha);
                break;
            case OXMinus:
                matrix[1][1] = Math.cos(-alpha);
                matrix[1][2] = Math.sin(-alpha);
                matrix[2][1] = -Math.sin(-alpha);
                matrix[2][2] = Math.cos(-alpha);
                break;
            case OYMinus:
                matrix[0][0] = Math.cos(-alpha);
                matrix[0][2] = -Math.sin(-alpha);
                matrix[2][0] = Math.sin(-alpha);
                matrix[2][2] = Math.cos(-alpha);
                break;
            case OZMinus:
                matrix[0][0] = Math.cos(-alpha);
                matrix[0][1] = Math.sin(-alpha);
                matrix[1][0] = -Math.sin(-alpha);
                matrix[1][1] = Math.cos(-alpha);
                break;
        }

        for (MyPoint myPoint : myPoints) {
            myPoint.changeCoordinates(matrix);
        }
    }
}
