import java.util.Scanner;

public class Main
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

        while (name.indexOf(spaceChar) == -1) {
            reEnterName();
        }

        setFullName();

        while ( (lastName.indexOf(spaceChar) != -1) || ( lastName.length() == 0 ) ) {
            reEnterName();
            setFullName();
        }

        getInfo();


    }

    private static void reEnterName() {
        System.out.print("Error, please enter correct name again: ");
        name = (scanner.nextLine()).trim();
    }

    public static void setFullName() {
        firstName = name.substring(0, name.indexOf(spaceChar));
        middleName = (name.substring(name.lastIndexOf(spaceChar))).trim();
        lastName = (name.substring((firstName.length()), (name.length() - middleName.length()))).trim();
    }

    public static void getInfo() {
        System.out.println(" First Name: " + firstName);
        System.out.println("  Last Name: " + lastName);
        System.out.println("Middle Name: " + middleName);
    }

}
