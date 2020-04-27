package data;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MetroCore {

    private TreeMap<String, Line> number2line;
    private TreeSet<Station> stations;
    private TreeMap<Station, TreeSet<Station>> connections;

    public MetroCore() {
        number2line = new TreeMap<>();
        stations = new TreeSet<>();
        connections = new TreeMap<>();
    }

    public TreeMap<Station, TreeSet<Station>> getConnections() {
        return connections;
    }

    public Station getStation(String lineNumber, String name) {
        Station query = new Station(name, getLine(lineNumber));
        Station station = stations.ceiling(query);
        return station.equals(query) ? station : null;
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

    public void addConnection(List<Station> stations)
    {
        for(Station station : stations)
        {
            if(!connections.containsKey(station)) {
                connections.put(station, new TreeSet<>());
            }
            TreeSet<Station> connectedStations = connections.get(station);
            connectedStations.addAll(stations.stream()
                    .filter(s -> !s.equals(station)).collect(Collectors.toList()));
        }
    }

}
