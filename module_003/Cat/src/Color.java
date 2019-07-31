public enum Color {
    RED,
    WHITE,
    BLACK,
    GREY,
    MIXED;

    public static Color getRandom() {
        return Color.values()[(int) (Math.random() * Color.values().length)];
    }

}
