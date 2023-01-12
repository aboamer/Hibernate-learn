package hibernate.dao;

import hibernate.config.Config;
import hibernate.entities.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDao {

    public Integer addCourse(Course course) {

        Transaction transaction = null;

        try (Session session = Config.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Integer id = (Integer) session.save(course);

            transaction.commit();

            return id;
        } catch (Exception e) {

            e.printStackTrace();

            if (transaction != null) {

                transaction.rollback();
            }
        }
        return -1;
    }
}
