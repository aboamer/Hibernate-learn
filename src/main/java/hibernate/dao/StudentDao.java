package hibernate.dao;

import hibernate.config.Config;
import hibernate.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    public void addStudent(Student student) {

        Transaction transaction = null;

        Integer savedId = null;

        try (Session session = Config.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            System.out.println("same transaction -- " + transaction.hashCode());

            savedId = (Integer) session.save(student);

            transaction.commit();

            Student current = session.get(Student.class, savedId);

            System.out.println("same transaction here -- " + transaction.hashCode());

            System.out.println(current.getEmail());

        } catch (Exception e) {
            e.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }

        try (Session session = Config.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            System.out.println("another transaction -- " + transaction.hashCode());

            Student current = session.get(Student.class, savedId);

            System.out.println(current.getEmail());

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
