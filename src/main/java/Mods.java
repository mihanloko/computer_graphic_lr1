public enum Mods {
    Rotation(0),
    Translation(1),
    Dilation(2),
    Reflection(3);

    private int num;

    Mods(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
