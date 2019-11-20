import Accounts.CardsAcc;
import Accounts.DepositAcc;
import Accounts.MainAccount;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        MainAccount Vasya = new MainAccount(50000.);
        System.out.println(Vasya.getAmount());
        Vasya.cashIn(50000.);
        System.out.println(Vasya.getAmount());
        Vasya.cashIn(20000.);
        Vasya.cashOut(100000.);
        Vasya.cashOut(1000000.);
        System.out.println(Vasya.getAmount());


        DepositAcc depositVasya = new DepositAcc(200000.);
        depositVasya.cashOut(50000.);
        depositVasya.setLastCashInDate(LocalDate.of(2019,10,10));
        depositVasya.cashOut(50000.);
        System.out.println(depositVasya.getAmount());


        CardsAcc cardVasya = new CardsAcc(35000.);
        cardVasya.cashOut(30000.);
        System.out.println(cardVasya.getAmount());


    }
}
