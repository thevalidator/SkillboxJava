import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;

public class RoadCalculatorTest extends TestCase {

    List<Station> route;
    RouteCalculator routeCalculator;
    StationIndex stationIndex;
    Line line1;
    Line line2;
    Line line3;

    @Override
    protected void setUp() throws Exception{

//        route = new ArrayList<>();
        stationIndex = new StationIndex();

        line1 = new Line(1,"one");
        line2 = new Line(2, "two");
        line3 = new Line(3,"three");

        //почему при объявлении Station stationIndex внутри метода, не работает addLine()?
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        //creating stations on 3 lines
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

        //creating connections
        List<Station> connectionOneWithTwo = new ArrayList<>();
        connectionOneWithTwo.add(stationIndex.getStation("13"));
        connectionOneWithTwo.add(stationIndex.getStation("23"));
        List<Station> connectionThreeWithTwo = new ArrayList<>();
        connectionThreeWithTwo.add(stationIndex.getStation("27"));
        connectionThreeWithTwo.add(stationIndex.getStation("32"));
        List<Station> connectionThreeWithOne = new ArrayList<>();
        connectionThreeWithOne.add(stationIndex.getStation("16"));
        connectionThreeWithOne.add(stationIndex.getStation("35"));
        stationIndex.addConnection(connectionOneWithTwo);
        stationIndex.addConnection(connectionThreeWithTwo);
        stationIndex.addConnection(connectionThreeWithOne);

        routeCalculator = new RouteCalculator(stationIndex);
    }

    // connection database test
    public void testGetConnectedStations() {
        Set<Station> actual = stationIndex.getConnectedStations(stationIndex.getStation("13"));
        Set<Station> expected = new TreeSet<Station>
                (Arrays.asList(stationIndex.getStation("23")));
        assertEquals(expected, actual);
    }
    public void testGetConnectedStations23() {
        Set<Station> actual = stationIndex.getConnectedStations(stationIndex.getStation("32"));
        Set<Station> expected = new TreeSet<Station>
                (Arrays.asList(stationIndex.getStation("27")));
        assertEquals(expected, actual);
    }
    public void testGetConnectedStations13() {
        Set<Station> actual = stationIndex.getConnectedStations(stationIndex.getStation("16"));
        Set<Station> expected = new TreeSet<Station>
                (Arrays.asList(stationIndex.getStation("35")));
        assertEquals(expected, actual);
    }

    //one line route test
    public void testGetShortestRoute() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("11"), stationIndex.getStation("17"));
        List<Station> expected = new ArrayList<>(Arrays.asList(stationIndex.getStation("11"),
                stationIndex.getStation("12"), stationIndex.getStation("13"),
                stationIndex.getStation("14"), stationIndex.getStation("15"),
                stationIndex.getStation("16"), stationIndex.getStation("17")));
        assertEquals(expected, actual);
    }

    //two lines route test
    public void testGetShortestRoute2Lines12() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("11"), stationIndex.getStation("24"));
        List<Station> expected = new ArrayList<>(Arrays.asList(stationIndex.getStation("11"),
                stationIndex.getStation("12"), stationIndex.getStation("13"),
                stationIndex.getStation("23"), stationIndex.getStation("24")));
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute2Lines12_reverse() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("24"), stationIndex.getStation("11"));
        List<Station> expected = new ArrayList<>(Arrays.asList(stationIndex.getStation("24"),
                stationIndex.getStation("23"), stationIndex.getStation("13"),
                stationIndex.getStation("12"), stationIndex.getStation("11")));
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute2Lines21() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("25"), stationIndex.getStation("11"));
        List<Station> expected = new ArrayList<>(Arrays.asList(stationIndex.getStation("25"),
                stationIndex.getStation("24"), stationIndex.getStation("23"),
                stationIndex.getStation("13"), stationIndex.getStation("12"),
                stationIndex.getStation("11")));
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute2Lines21_2() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("28"), stationIndex.getStation("11"));
        List<Station> expected = new ArrayList<>(Arrays.asList(stationIndex.getStation("28"),
                stationIndex.getStation("27"),
                stationIndex.getStation("26"), stationIndex.getStation("25"),
                stationIndex.getStation("24"), stationIndex.getStation("23"),
                stationIndex.getStation("13"), stationIndex.getStation("12"),
                stationIndex.getStation("11")));
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute2Lines21_3() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("26"), stationIndex.getStation("11"));
        List<Station> expected = new ArrayList<>(Arrays.asList(stationIndex.getStation("26"),
                stationIndex.getStation("25"),
                stationIndex.getStation("24"), stationIndex.getStation("23"),
                stationIndex.getStation("13"), stationIndex.getStation("12"),
                stationIndex.getStation("11")));
        assertEquals(expected, actual);
    }

    //three lines route test
    public void testGetShortestRoute3Lines13() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("11"), stationIndex.getStation("31"));
        List<Station> expected = new ArrayList<>(Arrays.asList(stationIndex.getStation("11"),
                stationIndex.getStation("12"), stationIndex.getStation("13"),
                stationIndex.getStation("23"), stationIndex.getStation("24"),
                stationIndex.getStation("25"), stationIndex.getStation("26"),
                stationIndex.getStation("27"), stationIndex.getStation("32"),
                stationIndex.getStation("31")));
        assertEquals(expected, actual);
    }
    public void testGetShortestRoute3Lines213() {
        List<Station> actual = routeCalculator.
                getShortestRoute(stationIndex.getStation("21"), stationIndex.getStation("37"));
        List<Station> expected = new ArrayList<>(Arrays.asList(stationIndex.getStation("21"),
                stationIndex.getStation("22"), stationIndex.getStation("23"),
                stationIndex.getStation("13"), stationIndex.getStation("14"),
                stationIndex.getStation("15"), stationIndex.getStation("16"),
                stationIndex.getStation("35"), stationIndex.getStation("36"),
                stationIndex.getStation("37")));
        assertEquals(expected, actual);
    }


    public void testCalculateDuration() {
        double actual = routeCalculator.calculateDuration(routeCalculator
                .getShortestRoute(stationIndex.getStation("11"), stationIndex.getStation("17")));
        double expected = 2.5 + 2.5 + 2.5 + 2.5 + 2.5 + 2.5;
        assertEquals(expected, actual);
    }




    // тест на нестыкующиеся станции
/*    public void testGetShortestrRoute() {
        List<Station> actual = routeCalculator.
                getShortestRoute(new Station("333", line1), new Station("111", line1) );
        List<Station> expected = null;
    }*/

    // тест на 1 пересадку
    // тест на несколько пересадок




    @Override
    protected void tearDown() throws Exception {

    }


/*    testGetShortestRoute()
     testCalculateDuration()
 */

}
