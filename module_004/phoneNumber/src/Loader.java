import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Scanner;

public class Loader {
    private static Scanner scanner = new Scanner(System.in);
    private static final int MIN_LENGTH = 11;

    public static void main(String[] args) {

        System.out.print("Enter phone number: ");
        String number = scanner.nextLine().trim().replaceAll("[^0-9]", "");

        showFormattedNumber(number);

        System.out.println(formatTwo(number));

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

    public static String formatTwo(String phoneNum) {
        String phoneMask;
        if (phoneNum.length() == MIN_LENGTH) {
            phoneMask = "+# ### ###-##-##";
        } else {
            phoneMask = "+## ### ###-##-##";
        }
        MaskFormatter maskFormatter = null;
        try {
            maskFormatter = new MaskFormatter(phoneMask);
            maskFormatter.setValueContainsLiteralCharacters(false);
            phoneNum = maskFormatter.valueToString(phoneNum);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return phoneNum;
    }

}
