package WorkFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Company {
    public ArrayList<Employee> EmployeeList;
    private double companyIncomeGoal;

    public Company() {
        EmployeeList = new ArrayList<>();
        companyIncomeGoal = 3000000;
    }

    public void hire() {
        double positionDefinition = Math.random();
        if (positionDefinition < 0.04) {
            EmployeeList.add(new TopManager());
            System.out.println("Welcome, Top Manager!");
        } else if (positionDefinition < 0.70 && positionDefinition >= 0.4) {
            EmployeeList.add(new Operator());
            System.out.println("Welcome, Operator!");
        } else {
            EmployeeList.add(new Manager());
            System.out.println("Welcome, Manager!");
        }
    }

    public void hireAll() {
        for (int topManager = 1; topManager <= 10; topManager++) {
            EmployeeList.add(new TopManager());
        }
        for (int manager = 1; manager <= 80; manager++) {
            EmployeeList.add(new Manager());
        }
        for (int operator = 1; operator <= 180; operator++) {
            EmployeeList.add(new Operator());
        }
    }

    public void fire() {
        EmployeeList.remove((int) (Math.random() * EmployeeList.size()));
    }

    public double getCompanyIncome() {
        double income = 0;
        for (int index = 0; index < EmployeeList.size(); index++) {
            income += EmployeeList.get(index).getSalesAmount();
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
        if (count >= EmployeeList.size()) {
            System.out.println("Error, the number can't be more than " + EmployeeList.size() + " at the moment.");
        } else {
            SalaryComparator salaryComparator = new SalaryComparator();
            EmployeeList.sort(Collections.reverseOrder(salaryComparator));
            System.out.println("TOP HIGHEST " + count + " SALARIES");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + EmployeeList.get(i).getMonthSalary(getCompanyIncome(), getCompanyIncomeGoal()));
            }
        }
    }

    public void getLowSalaryStaff(int count) {
        if (count >= EmployeeList.size()) {
            System.out.println("Error, the number can't be more than " + EmployeeList.size() + " at the moment.");
        } else {
            SalaryComparator salaryComparator = new SalaryComparator();
            EmployeeList.sort(salaryComparator);
            System.out.println("TOP LOWEST " + count + " SALARIES");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + EmployeeList.get(i).getMonthSalary(getCompanyIncome(), getCompanyIncomeGoal()));
            }
        }
    }


    public class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee one, Employee another) {
            if (one.getMonthSalary(getCompanyIncome(),getCompanyIncomeGoal()) == another.getMonthSalary(getCompanyIncome(),getCompanyIncomeGoal())) {
                return 0;
            }
            if (one.getMonthSalary(getCompanyIncome(),getCompanyIncomeGoal()) > another.getMonthSalary(getCompanyIncome(),getCompanyIncomeGoal())) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
