package Accounts;

import java.time.LocalDate;

public class MainAccount {

    private double ammount = 0.;
    private LocalDate dateOfCreation = LocalDate.now();;
    private double cashOutTotal = 0.;
    private double cashInTotal = 0.;


    public MainAccount(double ammount) {
        setAmmount(ammount);
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public void cashOut(double ammount) {
        setCashOutTotal(getCashOutTotal() - ammount);
        setAmmount(getAmmount() - ammount);
    }

    public double getCashOutTotal() {
        return cashOutTotal;
    }

    protected void setCashOutTotal(double cashOutTotal) {
        this.cashOutTotal = cashOutTotal;
    }

    public void cashIn(double ammount) {
        setCashInTotal(getCashInTotal() + ammount);
        setAmmount(getAmmount() + ammount);
    }

    public double getCashInTotal() {
        return cashInTotal;
    }

    protected void setCashInTotal(double cashInTotal) {
        this.cashInTotal = cashInTotal;
    }

    public void setDateOfCreation(int day, int month, int year) {
        dateOfCreation = LocalDate.of(year,month,day);
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }
}
