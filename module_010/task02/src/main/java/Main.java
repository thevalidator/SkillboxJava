import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    static SessionFactory sessionFactory;

    public static void main(String[] args) {

/*        try {
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        for (int i = 1; i < 4; i++) {
            Course course = session.get(Course.class, i);
            System.out.println(course.getName() + ": " + course.getPrice() + " руб.");
        }
        Student student = session.get(Student.class, 1);
        System.out.println(student.getName() + " " + student.getRegistrationDate());

        session.close();
        sessionFactory.close();
    }



    static protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

            Session session = sessionFactory.openSession();
            Course course = session.get(Course.class, 1);
            System.out.println(course.getName());
            session.close();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }
}
