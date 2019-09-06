import java.util.ArrayList;
import java.util.Scanner;

public class Loader {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> toDoList = new ArrayList<>();

    public static void main(String[] args) {

        String[] command;

        do {
            command = getCommand();
            if (command[0].equalsIgnoreCase("exit")) {
                break;
            }
            else if (command[0].equalsIgnoreCase("list")) {
                showList(toDoList);
            }
            else if (command[0].equalsIgnoreCase("add")) {
                if (command[1].matches("[0-9]+")) {
                    addTask(toDoList, Integer.parseInt(command[1]), command[2]);
                } else {
                    addTask(toDoList, command [1]);
                }
            }
            else if (command[0].equalsIgnoreCase("edit")) {
                editTask(toDoList, Integer.parseInt(command[1]), command[2]);
            }
            else if (command[0].equalsIgnoreCase("delete")) {
                deleteTask(toDoList, Integer.parseInt(command[1]));
            }
            else {
                System.out.println("*** wrong request! ***");
            }
        } while (true);

    }

    public static String[] getCommand() {
            System.out.print("Enter command: ");
        return scanner.nextLine().trim().split("\\s+");
    }

    private static void addTask(ArrayList<String> listName, int index, String task)  {
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
        listName.remove(index);
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
