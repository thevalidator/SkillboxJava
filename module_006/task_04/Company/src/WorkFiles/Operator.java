package WorkFiles;

public class Operator implements Employee {

    private double fixedSalary;
    private final static double SALARY_GRADE_INTERN = 0.7;
    private final static double SALARY_GRADE_ONE = 1.1;
    private static final double SALARY_GRADE_TWO = 1.2;

    public Operator() {
        fixedSalary = 30000.;
        //генерация категории сотрудника на занимаемой должности
        double grade = Math.random();
        if (grade < 0.25) {
            fixedSalary = fixedSalary * SALARY_GRADE_INTERN;
        }
        if (grade < 0.5 && grade >= 0.25) {
            fixedSalary = fixedSalary * SALARY_GRADE_TWO;
        }
        if (grade < 0.75 && grade >= 0.5) {
            fixedSalary = fixedSalary * SALARY_GRADE_ONE;
        }
    }

    @Override
    public double getMonthSalary(double companyIncome, double companyIncomeGoal) {
        return fixedSalary;
    }

    @Override
    public double getSalesAmount() {
        return 0;
    }
}
