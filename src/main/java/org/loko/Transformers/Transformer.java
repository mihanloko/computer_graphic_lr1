package org.loko.Transformers;

import org.loko.Directions;
import org.loko.Picture.*;

import java.util.LinkedList;

public interface Transformer {
    void transform(LinkedList<MyPoint> myPoints, Directions direction);
}
