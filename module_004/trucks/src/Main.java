import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int containersInTruck = 12;
        int boxesInContainer = 27;
        int trucksNeeded = 0;
        int containersNeeded = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter box ammount: ");
        int numberOfBoxes = scanner.nextInt();
        System.out.println();
        System.out.println(numberOfBoxes);

        // Q-ty of trucks
        trucksNeeded = (int)(Math.ceil( (double) numberOfBoxes / (containersInTruck * boxesInContainer)));
        // Q-ty of containers
        containersNeeded = (int)(Math.ceil( (double) numberOfBoxes / boxesInContainer));



        for(int i = 1, k = 1, b = 1; i <= trucksNeeded; i++) {
            System.out.println("Truck " + i + ":");

            for(int j = k; j <= (k + 11); j++) {
                if (j <= containersNeeded) {
                    System.out.println("     Container " + j);
                } else { break; }

                for(int l = b; l <= (b + 26); l++){
                    if (l <= numberOfBoxes) {
                        System.out.println("        Box " + l);
                    } else { break; }
                }
                b = j * boxesInContainer + 1;
            }
            k = i * containersInTruck + 1;
        }
        System.out.println();
        System.out.println("     TOTAL");
        System.out.println("========================");
        System.out.println("    trucks: " + trucksNeeded);
        System.out.println("containers: " + containersNeeded);
        System.out.println("     boxes: " + numberOfBoxes);

    }
}
