package data;

import java.util.ArrayList;

public class Station implements Comparable<Station> {
    private ArrayList<Line> line;
    private String name;

    public Station(String name, ArrayList<Line> line)
    {
        this.line = line;
        this.name = name;
    }

    public ArrayList<Line> getLine()
    {
        return line;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(Station station) {
        int lineComparison = line.get(0).compareTo(station.getLine().get(0));
        if(lineComparison != 0) {
            return lineComparison;
        }
        return name.compareToIgnoreCase(station.getName());
    }

}
