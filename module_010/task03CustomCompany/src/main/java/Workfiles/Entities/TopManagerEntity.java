package Workfiles.Entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TOPMANAGERS")
@PrimaryKeyJoinColumn(name = "TOPMANAGER_ID")
public class TopManagerEntity extends EmployeeEntity {

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

}
