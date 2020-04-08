import files.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        BankAccount userBankAccount = new BankAccount();
        String exportedTransactions = "src/files/movementList.csv";
        Pattern alfabankPattern = Pattern.compile("(.+),(?<accNumber>[0-9]+),([A-Z]+),"
                + "(?<date>\\d\\d\\.\\d\\d\\.\\d\\d),(.+),(.+),"
                + "(?<income>(\\d+)||\"(\\d+,\\d)*\"),(?<expense>(\\d+)||\"(\\d+,\\d*)\")$");

        try {
            List<String> lines = Files.readAllLines(Paths.get(exportedTransactions));
            for (String line : lines) {
                Matcher matcher = alfabankPattern.matcher(line);
                if (matcher.matches()) {

                    String accNumber = matcher.group("accNumber");
                    LocalDate date = LocalDate.parse(matcher.group("date"),
                            DateTimeFormatter.ofPattern("dd.MM.yy"));
                    double income = Double.parseDouble(matcher.group("income")
                            .replaceAll("\"","").replaceAll(",","."));
                    double expense = Double.parseDouble(matcher.group("expense")
                            .replaceAll("\"","").replaceAll(",","."));

                    userBankAccount.addTransaction(accNumber, Transaction.Currency.RUR, date, income, expense);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("TOTAL INCOME: " + userBankAccount.getTotalIncome() + " " + Transaction.Currency.RUR
                + "\nTOTAL EXPENSE: " + userBankAccount.getTotalExpense() + " " + Transaction.Currency.RUR);

    }
}
