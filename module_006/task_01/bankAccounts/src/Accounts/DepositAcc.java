package Accounts;

import java.time.LocalDate;

public class DepositAcc extends MainAccount {


    private LocalDate lastCashInDate = LocalDate.now();

    public DepositAcc(double amount) {
        super(amount);
    }

    @Override
    public void cashIn(double amount) {
        setAmount(getAmount() + amount);
        lastCashInDate = LocalDate.now();
    }

    @Override
    public void cashOut(double amount) {
        if (LocalDate.now().isAfter(lastCashInDate.plusMonths(1))) {
            setAmount(getAmount() - amount);
        } else {
            System.out.println("The block period has not expired!");
        }
    }

    public void setLastCashInDate(LocalDate date) {
        lastCashInDate = date;
    }


}
