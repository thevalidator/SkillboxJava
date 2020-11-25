package Workfiles;


public class TopManager extends Employee {

    public TopManager(Company company) {
        setCompany(company);
        monthSalary = getMonthSalary();
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
