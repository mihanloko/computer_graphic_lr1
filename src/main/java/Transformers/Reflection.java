package Transformers;

import Picture.Point;

import java.util.LinkedList;

public class Reflection implements Transformer {
    @Override
    public void transform(LinkedList<Point> points, Directions direction) {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        switch (direction) {
            case OXPlus:
            case OXMinus:
                matrix[0][0] = -1;
                break;
            case OYPlus:
            case OYMinus:
                matrix[1][1] = -1;
                break;
            case OZPlus:
            case OZMinus:
                matrix[2][2] = -1;
                break;
        }

        for (Point point: points) {
            point.changeCoordinates(matrix);
        }
    }
}
