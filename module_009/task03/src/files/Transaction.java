package files;

import java.time.LocalDate;
import java.util.HashMap;

public class Transaction {

    public enum Currency {USD, EUR, RUR}

    private String accountNumber;
    private Currency currency;
    private LocalDate date;
    private double income;
    private double expense;
    private String category;

    Transaction(String accountNumber, Currency currency, LocalDate date, String category, double income, double expense) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.date = date;
        this.category = category;
        this.income = income;
        this.expense = expense;
    }

    public String getCategory() {
        return category;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }
}
