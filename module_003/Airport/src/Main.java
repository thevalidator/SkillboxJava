import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Terminal;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();

        System.out.println(airport.getTerminals());
        System.out.println(airport.getAllAircrafts());


        Aircraft testCraft = new Aircraft("Falcon 8X");
        Aircraft testCraft2 = new Aircraft("Global Express 5000");
        Aircraft testCraft3 = new Aircraft("Cessna 650");


        Date testDate = new Date();
        Flight Milan = new Flight("MLN001", Flight.Type.DEPARTURE, testDate, testCraft);
        System.out.println(Milan.getAircraft() + " / " +  Milan.getCode() + " / " + Milan.getType() + " / " + Milan.getDate());
        Flight Paris = new Flight("PRS002", Flight.Type.DEPARTURE, testDate, testCraft2);
        System.out.println(Paris.getAircraft() + " / " +  Paris.getCode() + " / " + Paris.getType() + " / " + Paris.getDate());
        Flight Moscow = new Flight("MSC003", Flight.Type.ARRIVAL, testDate, testCraft3);
        System.out.println(Moscow.getAircraft() + " / " +  Moscow.getCode() + " / " + Moscow.getType() + " / " + Moscow.getDate());


        Terminal dmdVIP = new Terminal("Domodedovo VIP");
        dmdVIP.addFlight(Milan);
        dmdVIP.addParkingAircraft(testCraft);
        dmdVIP.addFlight(Paris);
        dmdVIP.addParkingAircraft(testCraft2);
        dmdVIP.addFlight(Moscow);

        System.out.println("====================================================================================");
        System.out.println("Terminal: " + dmdVIP.getName());
        System.out.println("Flights: " + dmdVIP.getFlights());
        System.out.println("Parked aircrafts: " + dmdVIP.getParkedAircrafts());






    }
}
