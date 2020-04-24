package data;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestForGson {

    TreeMap<String, ArrayList<String>> stations;
    ArrayList<ArrayList<StationsConnection>> connections;
    TreeSet<Line> lines;

    public TestForGson(TreeMap<String, ArrayList<String>> stations, TreeSet<Line> lines,
                       ArrayList<ArrayList<StationsConnection>> connections) {
        this.stations = stations;
        this.connections = connections;
        this.lines = lines;
    }

}
