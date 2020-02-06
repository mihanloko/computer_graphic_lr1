package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

public class Custom implements Transformer {
    private double factor;
    private int x;
    private int y;

    private static final Dilation dilation = new Dilation();
    private static final Translation translation = new Translation();

    @Override
    public void transform(LinkedList<MyPoint> myPoints, Directions direction) {
        translation.customTranslation(myPoints, -x, -y);

        dilation.customDilation(myPoints, factor);

        translation.customTranslation(myPoints, x, y);
    }

    public void setup(double factor, int x, int y) {
        this.factor = factor;
        this.x = x;
        this.y = y;
    }
}
