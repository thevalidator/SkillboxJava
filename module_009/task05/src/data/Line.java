package data;

import java.util.ArrayList;

public class Line implements Comparable<Line> {
    private String number;
    private String name;
    private String color;
    private ArrayList<Station> stations;

    public Line(String number, String name, String color)
    {
        this.number = number;
        this.name = name;
        this.color = color;
        stations = new ArrayList<>();
    }

    public String getNumber()
    {
        return number;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void addStation(Station station)
    {
        stations.add(station);
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(Line line) {
        return number.compareTo(line.getNumber());
    }
}
