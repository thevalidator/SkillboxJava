package Utilities;

import Workfiles.Company;
import Workfiles.Employee;
import Workfiles.Entities.*;


public class CompanyMapperDecorator implements CompanyMapper {

    private final CompanyMapper delegate;

    public CompanyMapperDecorator(CompanyMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public CompanyEntity companyToCompanyEntity(Company company) {
        CompanyEntity companyEntity = delegate.companyToCompanyEntity(company);
        for(EmployeeEntity e : companyEntity.getEmployeeList()) {
            e.setCompany(companyEntity);
        }
        return companyEntity;
    }

    @Override
    public Company companyEntityToCompany(CompanyEntity companyEntity) {
        Company company = delegate.companyEntityToCompany(companyEntity);
        for(Employee e : company.getEmployeeList()) {
            e.setCompany(company);
        }
        return company;
    }

}
