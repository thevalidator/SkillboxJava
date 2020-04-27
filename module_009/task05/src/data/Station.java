package data;

import java.util.Comparator;

public class Station implements Comparable<Station>{
    private Line line;
    private String name;

    public Station(String name, Line line)
    {
        this.name = name;
        this.line = line;
    }

    public Line getLine()
    {
        return line;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(Station station) {
        return Comparator.comparing(Station::getLine).thenComparing(s -> s.getName().toLowerCase())
                .compare(this, station);
    }

    @Override
    public boolean equals(Object obj)
    {
        return compareTo((Station) obj) == 0;
    }

    @Override
    public String toString()
    {
        return name;
    }


}
