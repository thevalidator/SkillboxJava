package Workfiles;


public abstract class Employee {

    protected Long id;

    protected Company company;

    protected double monthSalary;

    public abstract double getMonthSalary();

    public void setMonthSalary(double amount) {
        monthSalary = amount;
    }

    public double getSalesAmount() {
        return 0;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
