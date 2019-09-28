import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> toDoList = new ArrayList<>();

    public static void main(String[] args) {

        do {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            Matcher exit = Pattern.compile("^exit").matcher(input);
            Matcher list = Pattern.compile("^list").matcher(input);
            Matcher add = Pattern.compile("^add (?<deal>.+)").matcher(input);
            Matcher addIndexed = Pattern.compile("(^add) (?<num>\\d+) (?<deal>.+)").matcher(input);
            Matcher edit = Pattern.compile("(^edit) (?<num>\\d+) (?<deal>.+)").matcher(input);
            Matcher delete = Pattern.compile("(^delete) (?<num>\\d+)").matcher(input);

            if (exit.matches()) {
                break;
            } else if (addIndexed.matches()) {
                System.out.println("addIND!");
                addTaskIndexed(toDoList, getIndex(addIndexed), getDeal(addIndexed));
            } else if (add.matches()) {
                addTask(toDoList, getDeal(add));
            } else if (list.matches()) {
                showList(toDoList);
            } else if (delete.matches()) {
                deleteTask(toDoList, getIndex(delete));
            } else if (edit.matches()) {
                editTask(toDoList, getIndex(edit), getDeal(edit));
            } else {
                System.out.println("Invalid command");
            }
        } while (true);


    }

    static int getIndex(Matcher m) {
        return Integer.parseInt(m.group("num"));
    }

    static String getDeal(Matcher m) {
        return m.group("deal");
    }

    private static void addTaskIndexed(ArrayList<String> listName, int index, String task)  {
        if (index > (listName.size() - 1)) {
            listName.add(task);
        } else {
            listName.add(index, task);
        }
    }

    private static void addTask(ArrayList<String> listName, String task) {
        listName.add(task);
    }

    private static void deleteTask(ArrayList<String> listName, int index) {
        if (index > (listName.size() - 1)) {
            System.out.println("Error, no task with number " + index);
        } else {
            listName.remove(index);
        }
    }

    private static void editTask(ArrayList<String> listName, int index, String task) {
        if (index > (listName.size() - 1)) {
            System.out.println("Error, no task with number " + index);
        } else {
            listName.set(index, task);
        }
    }

    private static void showList(ArrayList<String> listName) {
        if (listName.size() == 0) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < listName.size(); i++) {
                System.out.println(i + ": " + listName.get(i));
            }
        }
    }
}