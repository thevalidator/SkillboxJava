package Workfiles;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGERS")
public class Manager extends Employee {

    private Company company;
    private double salesAmount;

    public Manager(Company company) {
        this.company = company;

        //генерация суммы продаж работника в диапазоне от 50.000 до 100.000
        salesAmount = 100000. * ((int)((Math.random() * 5) + 5)) / 10;
    }

    @Override
    public double getMonthSalary() {
        return 50000. + company.getCompanyIncome() * 0.05;
    }

    @Override
    public double getSalesAmount() {
        return salesAmount;
    }
}
