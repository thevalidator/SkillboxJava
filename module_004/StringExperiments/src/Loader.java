import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(text);

        int totalSalary = 0;

        var match = Pattern.compile("(?<salary>\\d+)").matcher(text);
        while (match.find()) {
            totalSalary += Integer.parseInt(match.group("salary"));
        }
        System.out.println(totalSalary);
    }
}
