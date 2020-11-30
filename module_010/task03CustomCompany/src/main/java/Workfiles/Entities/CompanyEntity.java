package Workfiles.Entities;

import Workfiles.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMPANIES")
public class CompanyEntity {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    @GenericGenerator(
            name = "ID_GENERATOR",
            strategy = "enhanced-sequence",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "JP_SEQUENCE"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "201")
            }
    )
    @Column(name = "COMPANY_ID")
    private long id;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @OneToMany(mappedBy = "companyEntity", fetch = FetchType.EAGER)
    protected List<EmployeeEntity> employeeList = new ArrayList<EmployeeEntity>();

    @Column(name = "INCOME_GOAL")
    protected double companyIncomeGoal;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<EmployeeEntity> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeEntity> employeeList) {
        this.employeeList = employeeList;
    }

    public double getCompanyIncomeGoal() {
        return companyIncomeGoal;
    }

    public void setCompanyIncomeGoal(double companyIncomeGoal) {
        this.companyIncomeGoal = companyIncomeGoal;
    }


}
