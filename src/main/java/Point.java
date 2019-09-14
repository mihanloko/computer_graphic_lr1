import java.util.Arrays;

public class Point {
    private double[] coordinates = new double[4];
    public Point(double x, double y, double z, double h) {
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = z;
        coordinates[3] = h;
    }
    public Point(double x, double y, double z) {
        this(x, y, z, 1.0);
    }

    public Point multiply(double[][] matrix) {
        double[] result = new double[4];
        for (int i = 0; i < 4; i++) {
            result[i] = 0;
            for (int j = 0; j < 4; j++) {
                result[i] += coordinates[j] * matrix[j][i];
            }
        }
        return new Point(result[0], result[1], result[2]);
    }

    public double[] getCoordinates() {
        return coordinates;
    }


    @Override
    public String toString() {
        return "Point{" +
                "coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
