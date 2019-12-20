package Workfiles;

public class Operator extends Employee {

    private Company company;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return 30000.;
    }
}
