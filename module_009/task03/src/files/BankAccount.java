package files;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class BankAccount {

    private ArrayList<Transaction> transactions;

    public BankAccount(){
        transactions = new ArrayList<>();
    }

    public void addTransaction(String accountNumber, Transaction.Currency currency, LocalDate date, String category, double income,
                               double expense) {
        transactions.add(new Transaction(accountNumber, currency, date, category, income, expense));
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

    private HashMap<String, Double> getCategories() {
        HashMap<String, Double> amountByCategories = new HashMap<>();
        for (Transaction transaction : transactions) {
            String key = transaction.getCategory();
            double value = 0.;
            if (amountByCategories.containsKey(key)) {
                value = amountByCategories.get(key);
            }
            amountByCategories.put(key, (value + (transaction.getIncome() - transaction.getExpense())));
        }
        return amountByCategories;
    }

    public void listTransactionsByCategories() {
        HashMap<String, Double> list = getCategories();
        for (String key : list.keySet()) {
            System.out.println(key + " " + list.get(key));
        }
    }


}
