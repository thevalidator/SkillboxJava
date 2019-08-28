import java.util.Scanner;

public class FullName
{
    private static Scanner scanner = new Scanner(System.in);
    private static char spaceChar = ' ';

    public static void main(String[] args) {
        String name = "empty empty empty";

        System.out.println("First name: " + getFistName(name));

        System.out.print("Enter Full Name (First, Last, Middle): ");
        name = askName();

        System.out.println("Last name: " + getLAstName(name));
        System.out.println("First name: " + getFistName(name));
        System.out.println("Middle name: " + getMiddleName(name));

    }

    public static String askName() {
        String name = (scanner.nextLine()).trim();
        while (!isCorrectName(name)) {
            System.out.print("Error, please enter the correct name: ");
            name = (scanner.nextLine()).trim();
        }
        return name;
    }

    private static boolean isCorrectName(String name) {
        if (name.indexOf(spaceChar) == -1) {
            return false;
        }
        if ((getLAstName(name).indexOf(spaceChar) != -1) || ( getLAstName(name).length() == 0 )) {
            return false;
        } else {
            return true;
        }
    }

    private static String getFistName(String name) {
        return (name.substring(0, name.indexOf(spaceChar)));
    }

    private static String getMiddleName(String name) {
        return ((name.substring(name.lastIndexOf(spaceChar))).trim());
    }

    private static String getLAstName(String name) {
        return ((name.substring((getFistName(name).length()), (name.length() - getMiddleName(name).length()))).trim());
    }

}
