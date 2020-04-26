import com.google.gson.*;
import data.Line;
import data.Station;
import data.MetroCore;
import parser.StructuredDataForGson;
import parser.WikiParser;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static MetroCore core;

    public static void main(String[] args) {

        Path tempFolder = Paths.get("tmp");
        Path metroStructureFile = tempFolder.resolve("structure.json");

        try {

            core = new MetroCore();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Files.createDirectories(tempFolder);
            /*FileWriter writer = new FileWriter(metroStructureFile.toFile(), false);
            WikiParser data = new WikiParser();

            StructuredDataForGson jsonData = data.getFullDataForJsonFile();
            String jsontxt = gson.toJson(jsonData);
            writer.write(jsontxt);
            writer.close();*/

            List<String> readJsonFile = Files.readAllLines(metroStructureFile);
            String jsonFile = "";
            for (String s : readJsonFile) {
                jsonFile = jsonFile.concat(s);
            }

            JsonObject object = gson.fromJson(jsonFile, JsonObject.class);

            JsonArray linesArray = object.getAsJsonArray("lines");
            parseLines(linesArray);
            JsonObject stationsMap = object.getAsJsonObject("stations");
            parseStations(stationsMap);

            core.getAllLines().forEach((n, line) -> {
                ArrayList<Station> stations = line.getStations();
                System.out.println(" ** " + line.getName() + " линия (" + stations.size() +  " станций) **");
                stations.forEach(station -> System.out.println("\t \t - " + station.getName()));

            });


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void parseLines(JsonArray array) {
        array.forEach(lineObject -> {
            Line line = new Line(
                    new Gson().fromJson(((JsonObject) lineObject).get("number"), String.class),
                    new Gson().fromJson(((JsonObject) lineObject).get("name"), String.class),
                    new Gson().fromJson(((JsonObject) lineObject).get("color"), String.class)
            );
            core.addLine(line);
        });
    }

    public static void parseStations(JsonObject object) {

        object.keySet().forEach(lineNumberObject -> {

            JsonArray stationsArray =  (object.get(lineNumberObject)).getAsJsonArray();
            stationsArray.forEach(s -> {
                String lineNumber = new Gson().fromJson(lineNumberObject, String.class);
                Line line = core.getLine(lineNumber);
                Station station = new Station(new Gson().fromJson(s, String.class), line);
                core.addStation(station);
                line.addStation(station);
            });

        });

    }

}

