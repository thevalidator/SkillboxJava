import Accounts.CarsAcc;
import Accounts.DepositAcc;
import Accounts.MainAccount;

import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        MainAccount Vasya = new MainAccount(50000.);
        Vasya.setDateOfCreation(23,10,2019);
        System.out.println(Vasya.getAmmount() + "  /  " + Vasya.getDateOfCreation().format(DateTimeFormatter.ofPattern("d.MM.yyyy")));
        Vasya.cashIn(50000.);
        System.out.println(Vasya.getAmmount() + "  /   " + Vasya.getCashInTotal());
        Vasya.cashIn(20000.);
        Vasya.cashOut(100000.);
        System.out.println(Vasya.getCashInTotal());
        System.out.println(Vasya.getAmmount() + "  /   " + Vasya.getCashInTotal() + "  /   " + Vasya.getCashOutTotal());


        DepositAcc depositVasya = new DepositAcc(200000.);
        depositVasya.cashOut(50000.);
        depositVasya.setLastCashInDate(18,10,2019);
        depositVasya.cashOut(50000.);
        System.out.println(depositVasya.getAmmount());


        CarsAcc cardVasya = new CarsAcc(35000.);
        cardVasya.cashOut(30000.);
        System.out.println(cardVasya.getAmmount());


    }
}
