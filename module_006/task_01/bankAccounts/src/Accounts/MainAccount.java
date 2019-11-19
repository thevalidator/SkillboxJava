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
        cashOutTotal -= ammount;
        setAmmount(getAmmount() - ammount);
    }

    public double getCashOutTotal() {
        return cashOutTotal;
    }

    public void cashIn(double ammount) {
        cashInTotal += ammount;
        setAmmount(getAmmount() + ammount);
    }

    public double getCashInTotal() {
        return cashInTotal;
    }

    public void setDateOfCreation(int day, int month, int year) {
        dateOfCreation = LocalDate.of(year,month,day);
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }
}
