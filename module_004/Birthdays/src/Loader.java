import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Loader {
    public static void main(String[] args) {

        int year = 1986;
        int month = 06;
        int day = 19;

        Locale.setDefault(Locale.ENGLISH);

        for (LocalDate birthdayDate = LocalDate.of(year,month,day);
             birthdayDate.isBefore(LocalDate.now()); birthdayDate = birthdayDate.plusYears(1)) {
            System.out.println((birthdayDate.getYear() - year) + " - " +
                    birthdayDate.format(DateTimeFormatter.ofPattern("d.MM.yyyy - E")));
        }

    }
}
