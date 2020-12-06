package Utilities;

import Workfiles.*;
import Workfiles.Entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper
@DecoratedWith(CompanyMapperDecorator.class)
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyEntity companyToCompanyEntity(Company company);

    @InheritInverseConfiguration
    Company companyEntityToCompany(CompanyEntity companyEntity);


    default EmployeeEntity employeeToEmployeeEntity(Employee e) {
        EmployeeEntity employeeEntity;
        if (e instanceof Operator) {
            employeeEntity = new OperatorEntity();
        } else if (e instanceof Manager) {
            employeeEntity = new ManagerEntity();
            ((ManagerEntity) employeeEntity).setSalesAmount(e.getSalesAmount());
        } else {
            employeeEntity = new TopManagerEntity();
        }
        employeeEntity.setMonthSalary(e.getMonthSalary());
        return employeeEntity;
    }

    default Employee employeeEntityToEmployee(EmployeeEntity eE) {
        Employee employee;
        if (eE instanceof OperatorEntity) {
            employee = new Operator();
        } else if (eE instanceof ManagerEntity) {
            employee = new Manager();
            ((Manager) employee).setSalesAmount(eE.getSalesAmount());
        } else {
            employee = new TopManager();
        }
        employee.setMonthSalary(eE.getMonthSalary());
        return employee;
    }

}
