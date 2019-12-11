package WorkFiles;

public class TopManager implements Employee {

    private double fixedSalary = 300000.;
    private double salesAmount;
    private static final double SALARY_GRADE_ONE = 1.05;
    private static final double SALARY_GRADE_TWO = 1.1;
    private static final double SALARY_GRADE_THREE = 1.2;

    public TopManager() {
        //генерация категории сотрудника на занимаемой должности
        double grade = Math.random();
        if (grade < 0.25) {
            fixedSalary = fixedSalary * SALARY_GRADE_THREE;
        }
        if (grade < 0.5 && grade >= 0.25) {
            fixedSalary = fixedSalary * SALARY_GRADE_TWO;
        }
        if (grade < 0.75 && grade >= 0.5) {
            fixedSalary = fixedSalary * SALARY_GRADE_ONE;
        }
        //генерация суммы продаж работника в диапазоне от 200.000 до 400.000
        salesAmount = 400000. * ((int)((Math.random() * 5) + 5)) / 10;
    }

    @Override
    public double getMonthSalary(Company company) {
        if (company.getCompanyIncome() > company.getCompanyIncomeGoal()) {
            return fixedSalary + fixedSalary * 1.5;
        } else {
            return fixedSalary;
        }
    }

    @Override
    public double getSalesAmount() {
        return salesAmount;
    }
}

