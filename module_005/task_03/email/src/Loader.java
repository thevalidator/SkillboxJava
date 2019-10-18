import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {

    private static HashSet<String> emails;
    private static Scanner scanner;

    public static void main(String[] args) {

        emails = new HashSet<>();
        scanner = new Scanner(System.in);

        Pattern emailFormat = Pattern.compile("[^\\s]+@[^\\s]+\\.[a-zA-Z]+");

        System.out.println("Instructions:");
        System.out.println("1) Type " + '"' + "add email" + '"' + " to add a new email to the list");
        System.out.println("2) Type " + '"' + "list" + '"' + " to show the list of emails");
        System.out.println("3) Type " + '"' + "exit" + '"' + " to close the program");

        do {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            Matcher exit = Pattern.compile("^exit").matcher(input);
            Matcher list = Pattern.compile("^list").matcher(input);
            Matcher add = Pattern.compile("^add (?<email>.+)").matcher(input);

            if (exit.matches()) {
                break;
            } else if (add.matches()) {
                Matcher email = emailFormat.matcher(getEmail(add));
                if (email.matches()) {
                    addEmail(getEmail(add));
                } else {
                    System.out.println("E-mail is not valid");
                }
            } else if (list.matches()) {
                showEmails();
            } else {
                System.out.println("Invalid command");
            }
        } while (true);
    }

    private static String getEmail(Matcher m) {
        return m.group("email");
    }

    private static void addEmail(String email) {
        emails.add(email);
    }

    public static void showEmails()  {
        if (emails.size() == 0) {
            System.out.println("The list is empty...");
        } else {
            for(String email : emails) {
                System.out.println((email));
            }
        }
    }

}
