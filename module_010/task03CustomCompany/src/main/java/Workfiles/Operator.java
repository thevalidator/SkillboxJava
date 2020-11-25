package Workfiles;


public class Operator extends Employee {

    public Operator(Company company) {
        setCompany(company);
        monthSalary = getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        return 30000.;
    }

}
