package hibernate.dao;

import hibernate.config.Config;
import hibernate.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    public void addStudent(Student student) {

        Transaction transaction = null;

        try (Session session = Config.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(student);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
