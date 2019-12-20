package Workfiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Company {
    public ArrayList<Employee> employeeList = new ArrayList<>();
    public double companyIncomeGoal = 3000000.;
    private Company company;

    public Company() {
        company = Company.this;
    }

    public void hire(String position) {
        if (position.equalsIgnoreCase("topmanager")) {
            employeeList.add(new TopManager(company));
        } else if (position.equalsIgnoreCase("manager")) {
            employeeList.add(new Manager(company));
        } else if (position.equalsIgnoreCase("operator")) {
            employeeList.add(new Operator(company));
        } else {
            System.out.println("incorrect employee position");
        }
    }

    public void hireAll() {
        for (int topManager = 1; topManager <= 10; topManager++) {
            employeeList.add(new TopManager(company));
        }
        for (int manager = 1; manager <= 80; manager++) {
            employeeList.add(new Manager(company));
        }
        for (int operator = 1; operator <= 180; operator++) {
            employeeList.add(new Operator(company));
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

    public double getCompanyIncomeGoal() {
        return companyIncomeGoal;
    }

    public void setCompanyIncomeGoal(double companyIncomeGoal) {
        this.companyIncomeGoal = companyIncomeGoal;
    }

    public void getTopSalaryStaff(int count) {
        if (count > employeeList.size() || count < 0) {
            System.out.println("Error, the number can't be more than " + employeeList.size() + " and less than zero.");
        } else {
            SalaryComparator salaryComparator = new SalaryComparator();
            employeeList.sort(Collections.reverseOrder(salaryComparator));
            System.out.println("TOP HIGHEST " + count + " SALARIES");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + employeeList.get(i).getMonthSalary());
            }
        }
    }

    public void getLowSalaryStaff(int count) {
        if (count > employeeList.size() || count < 0) {
            System.out.println("Error, the number can't be more than " + employeeList.size() + " at the moment.");
        } else {
            SalaryComparator salaryComparator = new SalaryComparator();
            employeeList.sort(salaryComparator);
            System.out.println("TOP LOWEST " + count + " SALARIES");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + employeeList.get(i).getMonthSalary());
            }
        }
    }

    public static class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee one, Employee another) {
            if (Math.abs(one.getMonthSalary() - another.getMonthSalary()) < 0.00000001) {
                return 0;
            }
            if (one.getMonthSalary() > another.getMonthSalary()) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}
