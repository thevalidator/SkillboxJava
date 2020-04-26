package data;

import java.util.TreeMap;
import java.util.TreeSet;

public class MetroCore {

    private TreeMap<String, Line> number2line;
    private TreeSet<Station> stations;

    public MetroCore() {
        number2line = new TreeMap<>();
        stations = new TreeSet<>();
    }

    public TreeMap<String, Line> getAllLines() {
        return number2line;
    }

    public Line getLine(String number) {
        return number2line.get(number);
    }

    public void addLine(Line line) {
        number2line.put(line.getNumber(), line);
    }

    public void addStation(Station station) {
        stations.add(station);
    }

}
