package Workfiles.Entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGERS")
@PrimaryKeyJoinColumn(name = "MANAGER_ID")
public class ManagerEntity extends EmployeeEntity {

    private double salesAmount;

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

    @Override
    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }
}
