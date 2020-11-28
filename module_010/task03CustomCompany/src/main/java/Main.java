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


public class Main {

    static SessionFactory sessionFactory;

    public static void main(String[] args) {

        final Logger LOG = LogManager.getLogger("trace");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();

        Company bellaz = new Company();
        LOG.info("new company created ");
        bellaz.setCompanyName("BELLAZ");
        LOG.info("company's name is set to " + bellaz.getCompanyName());
        Company scania = new Company();
        scania.setCompanyName("SCANIA");
        Company mercedes = new Company("MERCEDES");

        bellaz.hire(new Operator());
        LOG.info("Company " + bellaz.getCompanyName() + " hired new employee " + bellaz.getEmployeeList().get(0).getClass().toString());
        bellaz.hire(new Operator());
        LOG.info("Company " + bellaz.getCompanyName() + " hired new employee " + bellaz.getEmployeeList().get(1).getClass().toString());
        bellaz.hire(new Operator());
        LOG.info("Company " + bellaz.getCompanyName() + " hired new employee " + bellaz.getEmployeeList().get(2).getClass().toString());
        bellaz.hire(new Manager());
        LOG.info("Company " + bellaz.getCompanyName() + " hired new employee " + bellaz.getEmployeeList().get(3).getClass().toString());
        bellaz.hire(new Operator());
        LOG.info("Company " + bellaz.getCompanyName() + " hired new employee " + bellaz.getEmployeeList().get(4).getClass().toString());
        bellaz.hire(new Operator());
        LOG.info("Company " + bellaz.getCompanyName() + " hired new employee " + bellaz.getEmployeeList().get(5).getClass().toString());
        bellaz.hire(new Operator());
        LOG.info("Company " + bellaz.getCompanyName() + " hired new employee " + bellaz.getEmployeeList().get(6).getClass().toString());
        bellaz.hire(new Manager());
        LOG.info("Company " + bellaz.getCompanyName() + " hired new employee " + bellaz.getEmployeeList().get(7).getClass().toString());
        bellaz.hire(new TopManager());
        LOG.info("Company " + bellaz.getCompanyName() + " hired new employee " + bellaz.getEmployeeList().get(8).getClass().toString());

        scania.hire(new Operator());
        scania.hire(new Operator());
        scania.hire(new Operator());
        scania.hire(new Manager());
        scania.hire(new TopManager());

        save(bellaz);
        save(scania);
        save(mercedes);

        sessionFactory.close();

    }

    public static void loadFromDB() {

    }

    public static void save(Company c) {
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
    }

    public static CompanyEntity mapCompany(Company c) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCompanyName(c.getCompanyName());
        companyEntity.setCompanyIncomeGoal(c.getCompanyIncomeGoal());
        c.getEmployeeList().forEach(e -> {
            companyEntity.getEmployeeList().add(mapEmployee(e, companyEntity));
        });

        return companyEntity;
    }

    public static EmployeeEntity mapEmployee(Employee e, CompanyEntity cE) {

        EmployeeEntity employeeEntity;

        if (e instanceof Operator) {
            employeeEntity = new OperatorEntity();
            employeeEntity.setCompany(cE);
        } else if (e instanceof Manager) {
            employeeEntity = new ManagerEntity();
            ((ManagerEntity) employeeEntity).setSalesAmount(e.getSalesAmount());
        } else {
            employeeEntity = new TopManagerEntity();
        }
        employeeEntity.setMonthSalary(e.getMonthSalary());
        employeeEntity.setCompany(cE);

        return employeeEntity;
    }


}
