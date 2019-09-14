package Transformers;

import Picture.Point;

import java.util.LinkedList;

public class Translation implements Transformer {
    private static final int delta = 5;

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

        for (Point point: points) {
            point.changeCoordinates(matrix);
        }
    }

    void customTranslation(LinkedList<Point> points, int x, int y) {
        double[][] matrix = {
                {1, 0, 0 , 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {x, y, 0, 1}
        };

        for (Point point: points) {
            point.changeCoordinates(matrix);
        }
    }
}
