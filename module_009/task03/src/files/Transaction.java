package files;

import java.time.LocalDate;

public class Transaction {

    public enum Currency {USD, EUR, RUR}

    private String accountNumber;
    private Currency currency;
    private LocalDate date;
    private double income;
    private double expense;


    Transaction(String accountNumber, Currency currency, LocalDate date, double income, double expense) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.date = date;
        this.income = income;
        this.expense = expense;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }
}
