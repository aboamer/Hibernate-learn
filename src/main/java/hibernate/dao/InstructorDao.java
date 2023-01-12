package hibernate.dao;

import hibernate.config.Config;
import hibernate.entities.Course;
import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InstructorDao {

    CourseDao courseDao = new CourseDao();

    public Integer addInstructor(Instructor instructor, InstructorDetails instructorDetails) {

        Transaction transaction = null;

        try (Session session = Config.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(instructorDetails);

            instructor.setInstructorDetails(instructorDetails);

            Integer id = (Integer) session.save(instructor);

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

    public void addInstructorCourse(Instructor instructor, Course course) {

        Transaction transaction = null;

        try (Session session = Config.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            instructor.addCourse(course);

            courseDao.addCourse(course);

            transaction.commit();

        } catch (Exception e) {

            e.printStackTrace();

            if (transaction != null) {

                transaction.rollback();
            }
        }
    }

    public Instructor getInstructor(Integer id) {

        Transaction transaction = null;

        try (Session session = Config.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, id);

            transaction.commit();

            return instructor;
        } catch (Exception e) {

            e.printStackTrace();

            if (transaction != null) {

                transaction.rollback();
            }
        }

        return null;
    }
}
