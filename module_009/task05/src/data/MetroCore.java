package data;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MetroCore {

    TreeSet<Line> lines;
//1    TreeMap<Station, TreeSet<Station>> connections;

    public MetroCore()
    {
        lines = new TreeSet<>();
//1        connections = new TreeMap<>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    // перебираем линии, находим линию для станции и добавляем станцию на линию
    public void addStation(Station station) {

        for (Line line : lines) {
            if (station.getLine().equals(line)) {
                line.addStation(station);
            }
        }

    }


//1
    /*public void addConnection(List<Station> stations) {
        for(Station station : stations)
        {
            if(!connections.containsKey(station)) {
                connections.put(station, new TreeSet<>());
            }
            TreeSet<Station> connectedStations = connections.get(station);
            connectedStations.addAll(stations.stream()
                    .filter(s -> !s.equals(station)).collect(Collectors.toList()));
        }
    }*/




}
