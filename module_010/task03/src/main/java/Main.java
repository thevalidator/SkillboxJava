import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pkg.Student;
import utils.StudentUtility;

public class Main {
    public static void main(String[] args) {

        final Logger LOGGER = LogManager.getLogger("first");
        final SessionFactory SESSION_FACTORY;

        try {
            StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
            SESSION_FACTORY = metadata.getSessionFactoryBuilder().build();


            StudentUtility studentUtility = new StudentUtility(SESSION_FACTORY);

            for(Student student : studentUtility.findAll()) {
                System.out.println("ID: " + student.getId() + ", NAME: " + student.getName() + ", AGE: " +
                        student.getAge() + ", R.DATE: " + student.getRegistrationDate());
            }





            SESSION_FACTORY.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }


    }
}
