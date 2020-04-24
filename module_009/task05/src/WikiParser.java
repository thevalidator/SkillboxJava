import data.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class WikiParser {

    private static String stationsUrl = "https://ru.wikipedia.org/wiki/Список_станций_Московского_метрополитена";
    private static Document webSite;
    private static Elements rowsMetro;
    private static Elements rowsMonorels;
    private static Elements rowsMck;
    private static Elements rowLines;
    private static TreeSet<Line> lines;

    public WikiParser() throws IOException {
        webSite = Jsoup.connect(stationsUrl)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .timeout(7000).maxBodySize(0).get();
        rowsMetro = webSite.select("table:nth-child(7) > tbody > tr:has(td)");  // rows metro
        rowsMonorels = webSite.select("table:nth-child(9) > tbody > tr:has(td)");   // rows mck
        rowsMck = webSite.select("table:nth-child(11) > tbody > tr:has(td)");    // rows monorels
        rowLines = webSite.select("div[aria-labelledby=Линии_Московского_метрополитена] dd:has(a)");
        lines = getAllLines();
    }

    public TreeSet<Line> getAllLines() throws IOException {

        TreeSet<Line> linesList = new TreeSet<>();
        for (Element line : rowLines) {
            String number;
            if (!line.select("span").isEmpty()) {
                number = line.select("span[class=sortkey]").text();
            } else {
                continue;
            }
            String name = line.select("a").text();

            String color = "undefined";
            String lineLink = line.select("a[href]").attr("abs:href");
            String colorData = Jsoup.connect(lineLink).
                    userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0")
                    .timeout(7000).maxBodySize(0).ignoreHttpErrors(true).get()
                    .select("table.infobox > tbody > tr:nth-child(2) > td:has(span) > span")
                    .attr("style");

            if (!colorData.isEmpty()) {
                int cutStart = colorData.indexOf(":") + 1;
                int cutEnd = colorData.indexOf(";");
                color = colorData.substring(cutStart, cutEnd);
            }

            linesList.add(new Line(number, name, color));
        }
        return linesList;
    }

    //   METHOD WHICH RETURNS OBJECT WITH FULL DATA FOR JSON
    public TestForGson getAllData() throws IOException {
        //  *************  список линий
        TreeSet<Line> linesList = lines;
        //   ************  списки станций и пересадок
        TreeMap<String, ArrayList<String>> stationsByLines = new TreeMap<>();
        ArrayList<ArrayList<StationsConnection>> connectedStationsList = new ArrayList<>();
        Elements[] allStations = {rowsMetro, rowsMonorels, rowsMck};

        for (Elements elements : allStations) {

            for (Element row : elements) {
                // Получение данных из ячейки принадлежности к линии
                String[] stationLinesData = row.select("td:eq(0) span[class=sortkey]").text().split(" ");
                // Получение списка линий к которым принадлежит станция
                ArrayList<String> stationLines = new ArrayList<>();
                for (int i = 0; i < stationLinesData.length - 1; i++) {
                    stationLines.add(stationLinesData[i]);
                }
                // Проверка полученных номеров линий на совпадение со списком линий
                ArrayList<Line> lines = searchLine(stationLines);
                // Получени названия станции
                Element stationName = row.select("td:eq(1) a[title]").first();

                for( Line line : lines) {
                    String key = line.getNumber();
                    if(!stationsByLines.containsKey(key)) {
                        stationsByLines.put(key, new ArrayList<>());
                    }
                    ArrayList<String> value = stationsByLines.get(key);
                    value.add(stationName.text());
                    stationsByLines.put(key, value);

                    // поиск и создание списка станций пересадок с линиями
                    Elements transferLinesData = row.select("td:eq(3) span");
                    Elements interLineNumber = transferLinesData.select("span[class=sortkey]");
                    String[] lineNumbers = interLineNumber.text().split(" ");
                    List<String> transferStationNameLink = transferLinesData.select("span[title] a[href]")
                            .eachAttr("abs:href");

                    ArrayList<StationsConnection> connectedStations = new ArrayList<>();

                    if (!transferStationNameLink.isEmpty()) {
                        connectedStations.add(new StationsConnection(key, stationName.text()));
                        for (int i = 0; i < transferStationNameLink.size(); i++) {
                            Document page = Jsoup.connect(transferStationNameLink.get(i)).
                                    userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0")
                                    .timeout(7000).ignoreHttpErrors(true).get();

                            String lineNumber = lineNumbers[i];
                            String name = page.select("h1[id=firstHeading]").text();
                            if (name.contains("(")) {
                                name = name.substring(0, name.indexOf("(")).trim();
                            }
                            connectedStations.add(new StationsConnection(lineNumber, name));
                        }

                    }
                    if(!connectedStations.isEmpty()) {
                        connectedStationsList.add(connectedStations);
                    }
                }
                }

        }

        return new TestForGson(stationsByLines, linesList, connectedStationsList);

    }
    //  END  OF ONE  METHOD


    public static ArrayList<Line> searchLine (ArrayList<String> linesList) {
        ArrayList<Line> foundLines = new ArrayList<>();

        for (String text : linesList) {
            for (Line line : lines) {
                if (line.getNumber().equalsIgnoreCase(text)) {
                    foundLines.add(line);
                }
            }
        }

        return foundLines;
    }

}


