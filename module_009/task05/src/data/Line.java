package data;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Line implements Comparable<Line> {
    private String number;
    private String name;
    private String color;
    private transient List<Station> stations;


    public Line(String number, String name, String color)
    {
        this.number = number;
        this.name = name;
        this.color = color;
        stations = new ArrayList<>();
    }

    public List<Station> getStations()
    {
        return stations;
    }

    public String getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    @Override
    public int compareTo(Line line) {
        return number.compareTo(line.getNumber());
    }
}
