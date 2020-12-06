import Utilities.CompanyMapper;
import Workfiles.*;
import Workfiles.Entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;


public class Main {

    static SessionFactory sessionFactory;

    public static void main(String[] args) {

        final Logger LOG = LogManager.getLogger("trace");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();

/*        Company bellaz = new Company();
        bellaz.setCompanyName("belLAZ");
        Company scania = new Company("SCANIA");
        Company mercedes = new Company("MERCEDES");

        for (int i = 0; i < 6; i++) {
            bellaz.hire(new Operator());
        }
        for (int i = 0; i < 2; i++) {
            bellaz.hire(new Manager());
        }
        bellaz.hire(new TopManager());


        for (int i = 0; i < 3; i++) {
            scania.hire(new Operator());
        }
        scania.hire(new Manager());
        scania.hire(new TopManager());

        Company volvo = new Company("volvo");
        volvo.hire(new Operator());
        volvo.hire(new Manager());

        saveWithMapStruct(bellaz);
        saveWithMapStruct(scania);
        saveWithMapStruct(mercedes);
        saveWithMapStruct(volvo);*/


//        List<Company> list = loadFromDB();
        List<Company> list = loadWithMapstruct();
        for(Company c : list) {
            System.out.println("[" + c.hashCode() + "] " + c.getCompanyName() + " " + c.getEmployeeList().size());
        }

        List<Employee> eList = list.get(0).getEmployeeList();
        for (Employee e : eList) {
            System.out.println(e.getCompany().getCompanyName() + " " + e.getClass() + " " + e.getMonthSalary());
        }

        sessionFactory.close();

    }

/*    public static List<Company> loadFromDB() {
        List<Company> companies = new ArrayList<Company>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            List<CompanyEntity> companyEntities = session.createQuery("from CompanyEntity c" +
                    " join fetch c.employeeList l", CompanyEntity.class)
                    .list();
            for (CompanyEntity cE : companyEntities) {
                companies.add(mapCompany(cE));
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }*/

/*    public static void save(Company c) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            CompanyEntity companyEntity = mapCompany(c);
            session.save(companyEntity);
            if (!companyEntity.getEmployeeList().isEmpty()) {
                companyEntity.getEmployeeList().forEach(session::save);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void saveWithMapStruct ( Company c) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            CompanyEntity companyEntity = CompanyMapper.INSTANCE.companyToCompanyEntity(c);
            session.save(companyEntity);
            if (!companyEntity.getEmployeeList().isEmpty()) {
                companyEntity.getEmployeeList().forEach(session::save);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Company> loadWithMapstruct() {
        List<Company> companies = new ArrayList<Company>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            List<CompanyEntity> companyEntities = session.createQuery("from CompanyEntity c" +
                    " join fetch c.employeeList l", CompanyEntity.class)
                    .list();
            for (CompanyEntity cE : companyEntities) {
                companies.add(CompanyMapper.INSTANCE.companyEntityToCompany(cE));
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

/*    public static CompanyEntity mapCompany(Company c) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCompanyName(c.getCompanyName());
        companyEntity.setCompanyIncomeGoal(c.getCompanyIncomeGoal());
        c.getEmployeeList().forEach(e ->
            companyEntity.getEmployeeList().add(mapEmployee(e, companyEntity)));
        return companyEntity;
    }*/

/*    public static Company mapCompany(CompanyEntity cE) {
        Company company = new Company(cE.getCompanyName());
        List<Employee> temp = new ArrayList<>();
        company.setCompanyIncomeGoal(cE.getCompanyIncomeGoal());
        cE.getEmployeeList().forEach(e -> temp.add(mapEmployee(e, company)));
        company.setEmployeeList(temp);
        return company;
    }*/

/*    public static EmployeeEntity mapEmployee(Employee e, CompanyEntity cE) {
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
        employeeEntity.setCompany(cE);
        return employeeEntity;
    }*/

/*    public static Employee mapEmployee(EmployeeEntity eE, Company c) {
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
        employee.setCompany(c);

        return employee;
    }*/

}
