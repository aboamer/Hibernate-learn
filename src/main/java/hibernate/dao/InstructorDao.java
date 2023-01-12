package hibernate.dao;

import hibernate.config.Config;
import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InstructorDao {

    public void addInstructor(Instructor instructor, InstructorDetails instructorDetails) {

        Transaction transaction = null;

        try (Session session = Config.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(instructorDetails);

            instructor.setInstructorDetails(instructorDetails);

            session.save(instructor);

            transaction.commit();
        } catch (Exception e) {

            e.printStackTrace();

            if (transaction != null) {

                transaction.rollback();
            }
        }
    }
}
