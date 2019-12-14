package WorkFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Company {
    public ArrayList<Employee> employeeList;
    private double companyIncomeGoal;

    public Company() {
        employeeList = new ArrayList<>();
        companyIncomeGoal = 3000000;
    }

    public void hire(Employee position) {
        employeeList.add(position);
    }

    public void hireAll() {
        for (int topManager = 1; topManager <= 10; topManager++) {
            employeeList.add(new TopManager());
        }
        for (int manager = 1; manager <= 80; manager++) {
            employeeList.add(new Manager());
        }
        for (int operator = 1; operator <= 180; operator++) {
            employeeList.add(new Operator());
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
        if (count >= employeeList.size() || count < 0) {
            System.out.println("Error, the number can't be more than " + employeeList.size() + " and less than zero.");
        } else {
            SalaryComparator salaryComparator = new SalaryComparator(this);
            employeeList.sort(Collections.reverseOrder(salaryComparator));
            System.out.println("TOP HIGHEST " + count + " SALARIES");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + employeeList.get(i).getMonthSalary(this));
            }
        }
    }

    public void getLowSalaryStaff(int count) {
        if (count >= employeeList.size()) {
            System.out.println("Error, the number can't be more than " + employeeList.size() + " at the moment.");
        } else {
            SalaryComparator salaryComparator = new SalaryComparator(this);
            employeeList.sort(salaryComparator);
            System.out.println("TOP LOWEST " + count + " SALARIES");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + employeeList.get(i).getMonthSalary(this));
            }
        }
    }


    public class SalaryComparator implements Comparator<Employee> {

        private Company company;

        public SalaryComparator(Company company) {
            this.company = company;
        }
        @Override
        public int compare(Employee one, Employee another) {
            if (one.getMonthSalary(company) == another.getMonthSalary(company)) {
                return 0;
            }
            if (one.getMonthSalary(company) > another.getMonthSalary(company)) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
