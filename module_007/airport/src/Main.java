import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Airport lujaika = Airport.getInstance();
        ArrayList<Flight> filteredFlights = new ArrayList<>();
        for (Terminal terminal : lujaika.getTerminals()) {
            filteredFlights.addAll(terminal.getFlights());
        }

        System.out.println("A/C type      :      Depature time");
        System.out.println("===================================");
        Date fromDate = new Date(System.currentTimeMillis());
        Date toDate = new Date(System.currentTimeMillis() + 2 * 3600 * 1000);

        filteredFlights.stream()
                .filter(f -> (f.getDate().after(fromDate) && f.getDate().before(toDate)))
                .forEach(f -> System.out.println(f.getAircraft() + " : " + f.getDate()));

//        lujaika.getTerminals().stream().map(Terminal::getFlights).forEach(System.out::println);
        // почему map здесь не создается, а в предыдущем варианте создается? Потому что Stream.of возвращает map?
//        Stream.of(lujaika.getTerminals()).map(Terminal::getFlights).forEach(System.out::println);

    }
}
