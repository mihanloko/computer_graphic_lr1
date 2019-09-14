package Transformers;

import Picture.Point;

import java.util.LinkedList;

public class Custom implements Transformer {
    private double factor;
    private int x;
    private int y;

    private static final Dilation dilation = new Dilation();
    private static final Translation translation = new Translation();

    @Override
    public void transform(LinkedList<Point> points, Directions direction) {
        translation.customTranslation(points, -x, -y);

        dilation.customDilation(points, factor);

        translation.customTranslation(points, x, y);
    }

    public void setup(double factor, int x, int y) {
        this.factor = factor;
        this.x = x;
        this.y = y;
    }
}
