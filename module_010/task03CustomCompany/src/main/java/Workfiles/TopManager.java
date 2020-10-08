package Workfiles;

public class TopManager extends Employee {

    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        double fixedSalary = 300000.;
        if (company.getCompanyIncome() > company.companyIncomeGoal) {
            return fixedSalary + fixedSalary * 1.5;
        } else {
            return fixedSalary;
        }
    }

}
