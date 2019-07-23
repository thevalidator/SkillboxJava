import java.util.Scanner;

public class Main
{
    // Объявление и присвоение значений переменным типа int и double (границы доходов, траты на содержание, зарплаты, налогиб минимальная сумма инвестиций)
    private static int minIncome = 200000;
    private static int maxIncome = 900000;

    private static int officeRentCharge = 140000;
    private static int telephonyCharge = 12000;
    private static int internetAccessCharge = 7200;

    private static int assistantSalary = 45000;
    private static int financeManagerSalary = 90000;

    private static double mainTaxPercent = 0.24;
    private static double managerPercent = 0.15;

    private static double minInvestmentsAmount = 100000;

    private static double minFinIncome = (calculateFixedCharges() + minInvestmentsAmount - mainTaxPercent * calculateFixedCharges()) / ( 1 - (mainTaxPercent * (1 - managerPercent) + managerPercent));

    public static void main(String[] args)
    {
        // создание бесконечного цикла, в котором вводимое пользователя значение заносится в переменную income типа int
        while(true)
        {
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей. Прим. Компания может инвестировать при доходе от " + minFinIncome + " ): ");
            int income = (new Scanner(System.in)).nextInt();
        // проверяется входит ли введенное пользователем значение в заданный условиями диапазон с помощью метода checkIncomeRange
            if(!checkIncomeRange(income)) {
                continue; // если значение не попадает в заданный диапазон, цикл начинается заново
            }
        // объявление и присвоение значений переменным типа double и boolean
            double managerSalary = income * managerPercent;     //Зп менеджера
            double pureIncome = income - managerSalary -
                calculateFixedCharges();                        //Прибыль после вычета зп менеджера и трат на содержание офиса(фиксированных трат). Фиксированные траты высчиттываются в методе calculateFixedCharges()
            double taxAmount = mainTaxPercent * pureIncome;     //Размер налогов
            double pureIncomeAfterTax = pureIncome - taxAmount; //Чистая прибыль после вычета налогов
            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount;                           //Проверка на возможность инвестировать
            System.out.println("Зарплата менеджера: " + managerSalary); // вывод зп менеджера
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));                       // вывод общей суммы налогов
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));                   //  проверка тернарным оператором возможности компании инвестировать и вывод результата проверки
            if(pureIncome < 0) {                                        // проверка убыточности компании
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!"); // вывод сообщения об убыточности компании
            }
          }
    }

    private static boolean checkIncomeRange(int income) // метод checkIncomeRange, который проверяет переданное значение на соответствие заданным условиям, при соответствии возращает значение true, при несоответствии - печатает причину несоответствия и возращает значение false
    {
        if (income < minIncome) {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if (income > maxIncome) {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges() // метод, который считает фиксированные траты (аренда, платежи за услуги, зп персонала) и возвращает это значение
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
