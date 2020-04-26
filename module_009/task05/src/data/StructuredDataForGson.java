package data;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class StructuredDataForGson {

    TreeMap<String, ArrayList<String>> stations;
    ArrayList<ArrayList<StationsConnection>> connections;
    TreeSet<Line> lines;

    public StructuredDataForGson(TreeMap<String, ArrayList<String>> stations, TreeSet<Line> lines,
                                 ArrayList<ArrayList<StationsConnection>> connections) {
        this.stations = stations;
        this.connections = connections;
        this.lines = lines;
    }

}
