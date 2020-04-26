package parser;

import java.util.ArrayList;

public class StationForJson implements Comparable<StationForJson> {
    private ArrayList<LineForJson> line;
    private String name;

    public StationForJson(String name, ArrayList<LineForJson> line)
    {
        this.line = line;
        this.name = name;
    }

    public ArrayList<LineForJson> getLine()
    {
        return line;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(StationForJson station) {
        int lineComparison = line.get(0).compareTo(station.getLine().get(0));
        if(lineComparison != 0) {
            return lineComparison;
        }
        return name.compareToIgnoreCase(station.getName());
    }

}
