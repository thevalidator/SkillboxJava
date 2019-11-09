import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {

    private static Map<String, String> phoneBook = new TreeMap<>();

    public static void main(String[] args) {

        System.out.println("Manual:");
        System.out.println("1) For exit type: stop");
        System.out.println("2) To see the contacts list type: list");
        System.out.println("3) To search/add contact type name or number");
        System.out.println();

        System.out.println("Search: ");

        Scanner scanner = new Scanner(System.in);
        for(;;) {
            String input = scanner.nextLine();
            if(input.equals("stop")) {
                break;
            } else if(input.equals("list")) {
                showList();
            } else if((containsName(input) && containsNumber(phoneBook.get(input)))) {
                System.out.println("found ==> " + input + " : " + phoneBook.get(input));
            } else if((containsNumber(input)) && containsName(getKey( input))) {
                System.out.println("found ==> " + getKey(input) + " : " + input);
            } else {
                if (isName(input)) {
                    System.out.print("enter number: ");
                    putContact(input, formatNumber(scanner.nextLine()));
                } else {
                    System.out.print("enter name: ");
                    putContact(scanner.nextLine(), formatNumber(input));
                }
            }
        }
    }

    private static boolean isName(String input) {
        Matcher name = Pattern.compile(".+[a-zA-Z]+.+").matcher(input);
        if(name.matches()) {
            return true;
        } else {
            return false;
        }
    }

    private static String formatNumber(String number) {
        number = number.trim().replaceAll("[^0-9]", "");
        return number;
    }

    public static boolean containsName(String name) {
        return phoneBook.containsKey(name);
    }

    public static boolean containsNumber(String number) {
        return phoneBook.containsValue(number);
    }

    public static String getKey(String value) {
        for(String key : phoneBook.keySet()) {
            if(phoneBook.get(key).equals(value)) {
                return key;
            }
        }
        return null;
    }

    public static void showList() {
        for(String key : phoneBook.keySet()) {
            System.out.println(key + "==>" + phoneBook.get(key));
        }
    }

    private static void putContact(String name, String number) {
        phoneBook.put(name, number);
    }

}
