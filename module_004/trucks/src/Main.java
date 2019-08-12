import java.util.Scanner;

public class Main {
    private static final int MAX_CONTAINERS_IN_TRUCK = 12;
    private static final int MAX_BOXES_IN_CONTAINER = 27;

    public static void main(String[] args) {
        int trucksNeeded = 0;
        int containersNeeded = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter box ammount: ");
        int numberOfBoxes = scanner.nextInt();

        // Q-ty of trucks
        trucksNeeded = (int)(Math.ceil( (double) numberOfBoxes / (MAX_CONTAINERS_IN_TRUCK * MAX_BOXES_IN_CONTAINER)));
        // Q-ty of containers
        containersNeeded = (int)(Math.ceil( (double) numberOfBoxes / MAX_BOXES_IN_CONTAINER));

        for (int truck = 1; truck <= trucksNeeded; truck++) {
            System.out.println("Truck " + truck);
            for (int container = (1 + ((truck - 1) * MAX_CONTAINERS_IN_TRUCK)); container <= (MAX_CONTAINERS_IN_TRUCK * truck); container++) {
                if (container > containersNeeded) {
                    break;
                } else {
                    System.out.println("   Container " + container);
                    for (int box = (1 + ((container - 1) * MAX_BOXES_IN_CONTAINER)); box <= (MAX_BOXES_IN_CONTAINER * container); box++) {
                        if (box > numberOfBoxes) {
                            break;
                        } else {
                            System.out.println("      Box " + box);
                        }
                    }
                }
            }
        }



        System.out.println();
        System.out.println("     TOTAL");
        System.out.println("========================");
        System.out.println("    trucks: " + trucksNeeded);
        System.out.println("containers: " + containersNeeded);
        System.out.println("     boxes: " + numberOfBoxes);

    }
}
