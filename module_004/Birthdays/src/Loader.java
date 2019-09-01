import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loader {
    public static void main(String[] args) {
        int year = 1986;
        int month = 06;
        int day = 19;

        LocalDate birthdayDate = LocalDate.of(year,month,day);

        for (int yearCount = 0; yearCount < (LocalDate.now().getYear() - year); yearCount++) {
            System.out.println(yearCount + " - " + birthdayDate.withYear(year + yearCount).format(DateTimeFormatter.ofPattern("d.MM.yyyy - EE")) +
                    " - " +birthdayDate.withYear(yearCount).getDayOfWeek());
        }

    }
}
