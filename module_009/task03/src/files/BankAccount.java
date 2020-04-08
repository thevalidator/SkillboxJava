package files;

import java.time.LocalDate;
import java.util.ArrayList;

public class BankAccount {

    private ArrayList<Transaction> transactions;

    public BankAccount(){
        transactions = new ArrayList<>();
    }

    public void addTransaction(String accountNumber, Transaction.Currency currency, LocalDate date, double income,
                               double expense) {
        transactions.add(new Transaction(accountNumber, currency, date, income, expense));
    }

    public double getTotalIncome() {
        double totalIncome = 0.;
        for (Transaction transaction : transactions) {
            totalIncome += transaction.getIncome();
        }
        return totalIncome;
    }

    public double getTotalExpense() {
        double totalExpense = 0;
        for (Transaction transaction : transactions) {
            totalExpense += transaction.getExpense();
        }
        return totalExpense;
    }

}
