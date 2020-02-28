package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.MyPoint;

import java.util.LinkedList;

public class Custom implements Multiplier {
    private double factor;
    private int x;
    private int y;

    private static final Dilation DILATION = new Dilation();
    private static final Translation TRANSLATION = new Translation();

    @Override
    public void transform(LinkedList<MyPoint> myPoints, Directions direction) {
        TRANSLATION.customTranslation(myPoints, -x, -y);

        DILATION.customDilation(myPoints, factor);

        TRANSLATION.customTranslation(myPoints, x, y);
    }

    public void setup(double factor, int x, int y) {
        this.factor = factor;
        this.x = x;
        this.y = y;
    }
}
