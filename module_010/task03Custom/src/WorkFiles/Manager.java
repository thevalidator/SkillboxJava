package WorkFiles;

public class Manager implements Employee {

    private double fixedSalary = 50000.;
    private double salesAmount;
    private final static double SALARY_GRADE_INTERN = 0.75;
    private final static double SALARY_GRADE_ONE = 1.05;

    public Manager() {
        //генерация категории сотрудника на занимаемой должности
        double grade = Math.random();
        if (grade < 0.33) {
            fixedSalary = fixedSalary * SALARY_GRADE_INTERN;
        }
        if (grade < 0.66 && grade >= 0.33) {
            fixedSalary = fixedSalary * SALARY_GRADE_ONE;
        }
        //генерация суммы продаж работника в диапазоне от 50.000 до 100.000
        salesAmount = 100000. * ((int)((Math.random() * 5) + 5)) / 10;
    }

    @Override
    public double getMonthSalary(Company company) {
        return fixedSalary + company.getCompanyIncome() * 0.05;
    }

    @Override
    public double getSalesAmount() {
        return salesAmount;
    }
}


