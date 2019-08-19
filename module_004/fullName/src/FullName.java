import java.util.Scanner;

public class FullName
{
    private static Scanner scanner = new Scanner(System.in);
    private static String name;
    private static char spaceChar = ' ';
    private static String firstName;
    private static String lastName;
    private static String middleName;

    public static void main(String[] args) {

        System.out.print("Enter Full Name: ");
        name = (scanner.nextLine()).trim();

        setFullName();

        showFullName();

    }

    public static void setFullName () {
        while (name.indexOf(spaceChar) == -1) {
            reEnterFullName();
        }
        setFistName();
        setMiddleName();
        setLAstName();
        while ( (lastName.indexOf(spaceChar) != -1) || ( lastName.length() == 0 ) ) {
            reEnterFullName();
            setFistName();
            setMiddleName();
            setLAstName();
        }
    }

    private static void setFistName() {
        firstName = name.substring(0, name.indexOf(spaceChar));
    }

    private static void setMiddleName() {
        middleName = (name.substring(name.lastIndexOf(spaceChar))).trim();
    }

    private static void setLAstName() {
        lastName = (name.substring((firstName.length()), (name.length() - middleName.length()))).trim();

    }

    private static void reEnterFullName() {
        System.out.print("Error, please enter correct name again: ");
        name = (scanner.nextLine()).trim();
    }

    public static void showFullName() {
        System.out.println(" First Name: " + firstName);
        System.out.println("  Last Name: " + lastName);
        System.out.println("Middle Name: " + middleName);
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
