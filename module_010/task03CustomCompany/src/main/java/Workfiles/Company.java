package Workfiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Company {

    private String companyName;
    protected List<Employee> employeeList = new ArrayList<>();
    protected double companyIncomeGoal = 3000000.;

    public Company() {
    }
    public Company(String name) {
        this.companyName = name;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void hire(Employee employee) {
        employee.setCompany(this);
        employee.setMonthSalary(employee.getMonthSalary());
        employeeList.add(employee);
    }

    public void hireAll() {
        for (int topManager = 1; topManager <= 10; topManager++) {
            employeeList.add(new TopManager(this));
        }
        for (int manager = 1; manager <= 80; manager++) {
            employeeList.add(new Manager(this));
        }
        for (int operator = 1; operator <= 180; operator++) {
            employeeList.add(new Operator(this));
        }
    }

    public void fire(int index) {
        employeeList.remove(index);
    }

    public double getCompanyIncome() {
        double income = 0;
        for (Employee e : employeeList) {
            income += e.getSalesAmount();
        }
        return income;
    }

    public List<Employee> getEmployeeList() {
        return Collections.unmodifiableList(employeeList);
    }

    public double getCompanyIncomeGoal() {
        return companyIncomeGoal;
    }

    public void setCompanyIncomeGoal(double companyIncomeGoal) {
        this.companyIncomeGoal = companyIncomeGoal;
    }

    public void printTopSalaryStaff(int count) {
        if (count > employeeList.size() || count < 0) {
            System.out.println("Error, the number can't be more than " + employeeList.size() + " and less than zero.");
        } else {
            employeeList.sort(Comparator.comparingDouble(Employee::getMonthSalary).reversed());
            System.out.println("TOP HIGHEST " + count + " SALARIES");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + employeeList.get(i).getMonthSalary());
            }
        }
    }

    public void printLowSalaryStaff(int count) {
        if (count > employeeList.size() || count < 0) {
            System.out.println("Error, the number can't be more than " + employeeList.size() + " at the moment.");
        } else {
            employeeList.sort(Comparator.comparingDouble(Employee::getMonthSalary));
            System.out.println("TOP LOWEST " + count + " SALARIES");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + employeeList.get(i).getMonthSalary());
            }
        }
    }

}
