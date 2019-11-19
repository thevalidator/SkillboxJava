import java.util.*;

public class Loader {
    public static void main(String[] args) {

        final int MAX_REGION = 199;
        String letters = "ABCEHKMOPTXY";
        ArrayList<String> plates = new ArrayList<>();
        TreeSet<String> platesTreeSet = new TreeSet<>();
        HashSet<String> platesHashSet = new HashSet<>();

        for (int region = 1; region <= MAX_REGION; region++) {
            for (int letter = 0; letter < letters.length(); letter++) {
                for (int number = 1; number <= 9; number++) {
                    String plateNumber = letters.charAt(letter) + Integer.toString(number) + number + number + letters.charAt(letter) + letters.charAt(letter) + region;
                    plates.add(plateNumber.toUpperCase());
                }
            }
        }
//
//        for (int i = 0; i < plates.size(); i++) {
//            System.out.println(plates.get(i));
//        }

        platesHashSet.addAll(plates);
        platesTreeSet.addAll(plates);
        Collections.sort(plates);

//        for (int i = 0; i < plates.size(); i++) {
//            System.out.println(plates.get(i));
//        }

        Scanner scanner = new Scanner(System.in);
//        String searchPlateNum = "H333HH125";
        for(;;) {
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
