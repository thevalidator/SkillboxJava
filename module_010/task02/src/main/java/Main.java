import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    static SessionFactory sessionFactory;

    public static void main(String[] args) {

        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

            Session session = sessionFactory.openSession();

/*            for (int i = 1; i < 4; i++) {
                Course course = session.get(Course.class, i);
                System.out.println(course.getName() + ": " + course.getPrice() + " руб.");
            }
            Student student = session.get(Student.class, 4);
            System.out.println(student.getName() + " " + student.getRegistrationDate());*/

            Course course = session.get(Course.class, 1);
            System.out.println("Список студентов курса: " + course.getName());
            course.getStudents().forEach(s -> System.out.println((course.getStudents().indexOf(s) + 1)
                    + ": " + s.getName()));

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }

    }
}
