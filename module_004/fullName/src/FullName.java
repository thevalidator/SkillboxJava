import java.util.Scanner;

public class FullName
{
    private static Scanner scanner = new Scanner(System.in);
    private static String name;
    private static char spaceChar = ' ';


    public static void main(String[] args) {


        System.out.print("Enter Full Name (First, Last, Middle): ");
        askName();

        while (!isCorrectName()) {
            System.out.print("Error, please enter the correct name: ");
            askName();
        }

        System.out.println("Last name: " + getLAstName());
        System.out.println("First name: " + getFistName());
        System.out.println("Middle name: " + getMiddleName());

    }

    public static void askName() {
        name = (scanner.nextLine()).trim();
    }

    private static boolean isCorrectName() {
        if (name.indexOf(spaceChar) == -1) {
            return false;
        }
        if ((getLAstName().indexOf(spaceChar) != -1) || ( getLAstName().length() == 0 )) {
            return false;
        } else {
            return true;
        }
    }

    private static String getFistName() {
        return (name.substring(0, name.indexOf(spaceChar)));
    }

    private static String getMiddleName() {
        return ((name.substring(name.lastIndexOf(spaceChar))).trim());
    }

    private static String getLAstName() {
        return ((name.substring((getFistName().length()), (name.length() - getMiddleName().length()))).trim());
    }


    /*
    while (name.indexOf(spaceChar) == -1) {
            reEnterFullName();
        }
        firstName = name.substring(0, name.indexOf(spaceChar));
        middleName = (name.substring(name.lastIndexOf(spaceChar))).trim();
        lastName = (name.substring((firstName.length()), (name.length() - middleName.length()))).trim();
        while ( (lastName.indexOf(spaceChar) != -1) || ( lastName.length() == 0 ) ) {
            reEnterFullName();
            firstName = name.substring(0, name.indexOf(spaceChar));
            middleName = (name.substring(name.lastIndexOf(spaceChar))).trim();
            lastName = (name.substring((firstName.length()), (name.length() - middleName.length()))).trim();
        }
     */

}
