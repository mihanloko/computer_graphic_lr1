package org.loko;

public enum Mods {
    TRANSLATION(0),
    DILATION(1),
    ROTATION(2),
    REFLECTION(3),
    CUSTOM(4);

    private int num;

    Mods(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
