import java.util.Scanner;

public class FullName
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter Full Name (First, Last, Middle): ");
        String[] name = askName();

        System.out.println("Last name: " + getLAstName(name));
        System.out.println("First name: " + getFistName(name));
        System.out.println("Middle name: " + getMiddleName(name));
    }

    public static String[] askName() {
        String[] name = scanner.nextLine().trim().split("\\s+");
        while (name.length != 3) {
            System.out.print("Error, enter again: ");
            name = scanner.nextLine().trim().split("\\s+");
        }
        return name;
    }

    private static String getFistName(String[] name) {
        return name[0];
    }

    private static String getMiddleName(String[] name) {
        return name[1];
    }

    private static String getLAstName(String[] name) {
        return name[2];
    }

}
