public class Main {
    public static void main(String[] args) {
        for (int ticketNumber = 200000; ticketNumber <=210000; ticketNumber++){
            System.out.println("Ticket number: " + ticketNumber);
        }
        for (int ticketNumber = 220000; ticketNumber <=235000; ticketNumber++){
            System.out.println("Ticket number: " + ticketNumber);
        }
        //using while
        int tN = 200000;
        while (tN <= 210000){
            System.out.println("Номер билета: " + tN);
            tN++;
        }
        tN = 220000;
        while (tN <= 235000){
            System.out.println("Номер билета: " + tN);
            tN++;
        }
    }
}
