import java.util.*;

public class Loader {
    public static void main(String[] args) {

        String letters = "ABCEHKMOPTXY";
        ArrayList<String> plates = new ArrayList<>();
        TreeSet<String> platesTreeSet = new TreeSet<>();
        HashSet<String> platesHashSet = new HashSet<>();

        for (int region = 1; region <= 199; region++) {
            for (int letter = 0; letter < letters.length(); letter++) {
                for (int number = 1; number <= 9; number++) {
                    String plateNumber = letters.charAt(letter) + Integer.toString(number) + number + number
                            + letters.charAt(letter) + letters.charAt(letter) + region;
                    plates.add(plateNumber.toUpperCase());
                }
            }
        }

        platesHashSet.addAll(plates);
        platesTreeSet.addAll(plates);
        Collections.sort(plates);


        Scanner scanner = new Scanner(System.in);
//        String searchPlateNum = "H333HH125";
        for(;;) {
            System.out.print("Enter plate number: ");
            String searchPlateNum = scanner.nextLine().toUpperCase();
            long startTime;
            long totalTime;

    //            прямой перебор contains
            startTime = System.nanoTime();
            System.out.print(plates.contains(searchPlateNum));
            totalTime = System.nanoTime() - startTime;
            System.out.println(" ===>  direct search: " + totalTime);

    //            бинарный поиск collections.binarySearch()
            startTime = System.nanoTime();
            System.out.print(Collections.binarySearch(plates, searchPlateNum));
            totalTime = System.nanoTime() - startTime;
            System.out.println(" ===>  binary search: " + totalTime);

    //            TreeSet
            startTime = System.nanoTime();
            System.out.print(platesTreeSet.contains(searchPlateNum));
            totalTime = System.nanoTime() - startTime;
            System.out.println(" ===> treeSet search: " + totalTime);

    //            HashSet
            startTime = System.nanoTime();
            System.out.print(platesHashSet.contains(searchPlateNum));
            totalTime = System.nanoTime() - startTime;
            System.out.println(" ===> hashSet search: " + totalTime);
            System.out.println("============================");
        }

    }
}
