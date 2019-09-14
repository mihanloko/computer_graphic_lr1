public enum Mods {
    Translation(0),
    Dilation(1),
    Rotation(2),
    Reflection(3);

    private int num;

    Mods(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
