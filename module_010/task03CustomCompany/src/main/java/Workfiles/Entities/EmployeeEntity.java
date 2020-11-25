package Workfiles.Entities;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EmployeeEntity {

    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    protected CompanyEntity companyEntity;

    @Column(name = "MONTHS_SALARY")
    protected double monthSalary;


    public abstract double getMonthSalary();

    public void setMonthSalary(double amount) {
        monthSalary = amount;
    }

    public double getSalesAmount() {
        return 0;
    }

    public CompanyEntity getCompany() {
        return companyEntity;
    }

    public void setCompany(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }
}
