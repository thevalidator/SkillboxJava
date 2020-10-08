import Utilities.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentModel {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final Logger LOGGER = LogManager.getLogger("studentModel");

    public void create(Student student) {
        Boolean result = true;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            result = false;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        LOGGER.info("Student with ID:" + student.getId() + " was added successfully");
    }

    public List<Student> findAll() {
        List<Student> students = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Student");
            students = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            students = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return students;
    }
}
