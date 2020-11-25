package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pkg.Student;

import java.util.List;

public class StudentUtility {

    private SessionFactory sessionFactory;

    public StudentUtility(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Student> findAll() {
        List<Student> students = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query<Student> query = session.createQuery("from Student", Student.class);
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
