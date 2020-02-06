package org.loko.Picture;

import java.util.Arrays;

public class MyPoint {
    private double[] coordinates = new double[4];
    public MyPoint(double x, double y, double z, double h) {
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = z;
        coordinates[3] = h;
    }
    public MyPoint(double x, double y, double z) {
        this(x, y, z, 1.0);
    }

    public MyPoint multiply(double[][] matrix) {
        double[] result = new double[4];
        for (int i = 0; i < 4; i++) {
            result[i] = 0;
            for (int j = 0; j < 4; j++) {
                result[i] += coordinates[j] * matrix[j][i];
            }
        }
        return new MyPoint(result[0], result[1], result[2]);
    }

    public void changeCoordinates(double[][] matrix) {
        MyPoint result = this.multiply(matrix);
        this.coordinates = result.getCoordinates();
    }

    public double[] getCoordinates() {
        return coordinates;
    }


    @Override
    public String toString() {
        return "org.loko.Picture.Point{" +
                "coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
