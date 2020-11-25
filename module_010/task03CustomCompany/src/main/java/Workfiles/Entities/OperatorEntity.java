package Workfiles.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "OPERATORS")
@PrimaryKeyJoinColumn(name = "OPERATOR_ID")
public class OperatorEntity extends EmployeeEntity{

    @Id
    protected long id;

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }
}
