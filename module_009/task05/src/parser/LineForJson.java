package parser;

public class LineForJson implements Comparable<LineForJson> {
    private String number;
    private String name;
    private String color;

    public LineForJson(String number, String name, String color)
    {
        this.number = number;
        this.name = name;
        this.color = color;
    }

    public String getNumber()
    {
        return number;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(LineForJson line) {
        return number.compareTo(line.getNumber());
    }
}
