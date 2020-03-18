import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;

public class RoadCalculatorTest extends TestCase {

    RouteCalculator routeCalculator;
    StationIndex stationIndex;
    Line line1;
    Line line2;
    Line line3;
    Line line4;
    Line line5;

    public List<Station> makeRoute(int ... stations) {
        ArrayList<Station> route = new ArrayList<>();
        for(int index = 0; index < stations.length; index++) {
            route.add(stationIndex.getStation(Integer.toString(stations[index])));
        }
        return route;
    }

    @Override
    protected void setUp() throws Exception{

//        route = new ArrayList<>();
        stationIndex = new StationIndex();

        line1 = new Line(1,"one");
        line2 = new Line(2, "two");
        line3 = new Line(3,"three");
        line4 = new Line(4,"four");
        line5 = new Line(5,"five");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addLine(line4);
        stationIndex.addLine(line5);

        //creating stations on 5 lines
        for (int lineStation = 11; lineStation < 18; lineStation++) {
            Station station = new Station(Integer.toString(lineStation), line1);
            stationIndex.addStation(station);
            line1.addStation(station);
        }
        for (int lineStation = 21; lineStation < 29; lineStation++) {
            Station station = new Station(Integer.toString(lineStation), line2);
            stationIndex.addStation(station);
            line2.addStation(station);
        }
        for (int lineStation = 31; lineStation < 38; lineStation++) {
            Station station = new Station(Integer.toString(lineStation), line3);
            stationIndex.addStation(station);
            line3.addStation(station);
        }
        for (int lineStation = 41; lineStation < 47; lineStation++) {
            Station station = new Station(Integer.toString(lineStation), line4);
            stationIndex.addStation(station);
            line4.addStation(station);
        }
        for (int lineStation = 51; lineStation < 56; lineStation++) {
            Station station = new Station(Integer.toString(lineStation), line5);
            stationIndex.addStation(station);
            line5.addStation(station);
        }

        //creating connections
        List<Station> connectionOneWithTwo = new ArrayList<>();
        connectionOneWithTwo.add(stationIndex.getStation("13"));
        connectionOneWithTwo.add(stationIndex.getStation("23"));
        stationIndex.addConnection(connectionOneWithTwo);

        List<Station> connectionTwoWithThreeWithFour = new ArrayList<>();
        connectionTwoWithThreeWithFour.add(stationIndex.getStation("27"));
        connectionTwoWithThreeWithFour.add(stationIndex.getStation("32"));
        connectionTwoWithThreeWithFour.add(stationIndex.getStation("43"));
        stationIndex.addConnection(connectionTwoWithThreeWithFour);

        List<Station> connectionThreeWithOne = new ArrayList<>();
        connectionThreeWithOne.add(stationIndex.getStation("16"));
        connectionThreeWithOne.add(stationIndex.getStation("35"));
        stationIndex.addConnection(connectionThreeWithOne);

        routeCalculator = new RouteCalculator(stationIndex);
    }

    // connection database test
    public void testGetConnectedStationsLineOneAndTwo() {
        Set<Station> actual = stationIndex.getConnectedStations(stationIndex.getStation("13"));
        Set<Station> expected = new TreeSet<Station>
                (Arrays.asList(stationIndex.getStation("23")));
        assertEquals(expected, actual);
    }
    public void testGetConnectedStationsLineTwoAndThreeAndFour() {
        Set<Station> actual = stationIndex.getConnectedStations(stationIndex.getStation("32"));
        Set<Station> expected = new TreeSet<Station>
                (Arrays.asList(stationIndex.getStation("27"), stationIndex.getStation("43")));
        assertEquals(expected, actual);
    }
    public void testGetConnectedStationsLineOneAndThree() {
        Set<Station> actual = stationIndex.getConnectedStations(stationIndex.getStation("16"));
        Set<Station> expected = new TreeSet<Station>
                (Arrays.asList(stationIndex.getStation("35")));
        assertEquals(expected, actual);
    }

    //one line route test
    public void testGetShortestRouteOnLineOne() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("11"), stationIndex.getStation("17"));
        List<Station> expected = new ArrayList<>(Arrays.asList(stationIndex.getStation("11"),
                stationIndex.getStation("12"), stationIndex.getStation("13"),
                stationIndex.getStation("14"), stationIndex.getStation("15"),
                stationIndex.getStation("16"), stationIndex.getStation("17")));
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnLineOneRefactored() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("11"), stationIndex.getStation("17"));
        List<Station> expected = makeRoute(11, 12, 13, 14, 15, 16, 17);
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnLineFive() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("51"), stationIndex.getStation("55"));
        List<Station> expected = makeRoute(51, 52, 53, 54, 55);
        assertEquals(expected, actual);
    }

    //two lines route test
    public void testGetShortestRouteWithOneConnectionLinesOneAndTwo() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("11"), stationIndex.getStation("25"));
        List<Station> expected = makeRoute(11, 12, 13, 23, 24, 25);
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithOneConnectionLinesOneAndTwo_reverse() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("25"), stationIndex.getStation("11"));
        List<Station> expected = makeRoute(25, 24, 23, 13, 12, 11);
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithOneConnectionLinesOneAndTwo_AnotherWay() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("28"), stationIndex.getStation("11"));
        List<Station> expected = makeRoute(28, 27, 26, 25, 24, 23, 13, 12, 11);
        assertEquals(expected, actual);
    }

    //three lines route test
    public void testGetShortestRouteWithTwoConnectionsLineFourThroughLineThreeToLineOne() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("44"), stationIndex.getStation("17"));
        List<Station> expected = makeRoute(44, 43, 32, 33, 34, 35, 16, 17);
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithTwoConnectionsLineONeThroughLineTwoToLineFour() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("11"), stationIndex.getStation("44"));
        List<Station> expected = makeRoute(11, 12, 13, 23, 24, 25, 26, 27, 43, 44);
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithTwoConnectionsLineTwoThroughLineOneToLineThree() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("21"), stationIndex.getStation("37"));
        List<Station> expected = makeRoute(21, 22, 23, 13, 14, 15, 16, 35, 36, 37);
        assertEquals(expected, actual);
    }

    // time duration test
    public void testCalculateDuration() {
        double actual = routeCalculator.calculateDuration(routeCalculator
                .getShortestRoute(stationIndex.getStation("11"), stationIndex.getStation("17")));
        double expected = 2.5 + 2.5 + 2.5 + 2.5 + 2.5 + 2.5;
        assertEquals(expected, actual);
    }

    // тест на нестыкующиеся станции (где лучше отлавливать пустой маршрут? в самом методе или классе main)
    public void testGetShortestRouteWithNoConnection() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("21"), stationIndex.getStation("53"));
        assertEquals(new ArrayList<>(), actual);
    }

    // тест на верное определение самого быстрого маршрута
    public void testGetShortestRouteChekingByTimeDurationToOnePlace() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("25"), stationIndex.getStation("16"));
        List<Station> expected = makeRoute(25, 24, 23, 13, 14, 15, 16);
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteChekingByTimeDurationToOnePlaceAnotherWay() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("25"), stationIndex.getStation("35"));
        List<Station> expected = makeRoute(25, 26, 27, 32, 33, 34, 35);
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {

    }

}
