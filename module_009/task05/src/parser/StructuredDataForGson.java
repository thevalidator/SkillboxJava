package parser;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class StructuredDataForGson {

    TreeMap<String, ArrayList<String>> stations;
    ArrayList<ArrayList<StationsConnectionForJson>> connections;
    TreeSet<LineForJson> lines;

    public StructuredDataForGson(TreeMap<String, ArrayList<String>> stations,
                                 ArrayList<ArrayList<StationsConnectionForJson>> connections,
                                 TreeSet<LineForJson> lines) {
        this.stations = stations;
        this.connections = connections;
        this.lines = lines;
    }

    public TreeSet<LineForJson> getLines() {
        return lines;
    }
}
