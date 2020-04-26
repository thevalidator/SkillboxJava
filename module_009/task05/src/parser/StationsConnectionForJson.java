package parser;

public class StationsConnectionForJson {
    String line;
    String station;

    public StationsConnectionForJson(String lineNumber, String stationName) {
        this.line = lineNumber;
        this.station = stationName;
    }
}
