import bankAccounts.Individual;
import bankAccounts.Legal;
import bankAccounts.Physical;

public class Main {
    public static void main(String[] args) {

        Physical Andrew = new Physical(1000.);
        Legal CocaCola = new Legal(1000.);
        Individual CoffeeShop = new Individual(1000.);

        System.out.println("Starting balance");
        System.out.println("=====================================================");
        System.out.println("Phys: " + Andrew.getBalance() + "  |   Leg: " + CocaCola.getBalance() + "  |   Ind: " + CoffeeShop.getBalance());
        System.out.println("=====================================================");

        Andrew.cashIn(100.);
        CocaCola.cashIn(100.);
        CoffeeShop.cashIn(100.);
        CoffeeShop.cashIn(1000.);

        System.out.println("Balance after cash IN");
        System.out.println("=====================================================");
        System.out.println("Phys: " + Andrew.getBalance() + "  |   Leg: " + CocaCola.getBalance() + "  |   Ind: " + CoffeeShop.getBalance());
        System.out.println("=====================================================");

        Andrew.cashOut(100.);
        CocaCola.cashOut(100.);
        CoffeeShop.cashOut(100.);

        System.out.println("Balance after cash OUT");
        System.out.println("=====================================================");
        System.out.println("Phys: " + Andrew.getBalance() + "  |   Leg: " + CocaCola.getBalance() + "  |   Ind: " + CoffeeShop.getBalance());
        System.out.println("=====================================================");


    }
}
