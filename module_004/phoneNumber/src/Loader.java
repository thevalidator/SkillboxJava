import java.util.Scanner;

public class Loader {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter phone number: ");
        String number = scanner.nextLine().trim().replaceAll("[^0-9]", "");

        showFormattedNumber(number);

    }

    public static void showFormattedNumber(String number) {
        String spacer = " ";
        String countryCodeSection = "+7";
        String codeSection = number.substring((number.length() - 10), (number.length() - 7));
        String firstSection = number.substring((number.length() - 7), (number.length() - 4));
        String secondSection = number.substring((number.length() - 4), (number.length() - 2));
        String thirdSection = number.substring(number.length() - 2);
        System.out.println(countryCodeSection + spacer + codeSection + spacer + firstSection + spacer + secondSection
                + spacer + thirdSection);
    }

}
