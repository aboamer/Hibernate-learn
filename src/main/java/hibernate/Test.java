package hibernate;

import hibernate.dao.CourseDao;
import hibernate.dao.InstructorDao;
import hibernate.dao.StudentDao;
import hibernate.entities.Course;
import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;
import hibernate.entities.Student;

public class Test {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();

        Student student = Student.builder().firstName("Ramesh").lastName("Fadatare").email("ramesh@gmail.com").build();

        studentDao.addStudent(student);

        System.out.println("Done ------- " + student.getId());

        InstructorDao instructorDao = new InstructorDao();

        Instructor instructor = Instructor.builder().firstName("moh").lastName("amer").email("amer@mail.com").build();

        InstructorDetails instructorDetails = InstructorDetails.builder().youtubeChannel("amer_ch").hobby("football").build();

        Integer instructorId = instructorDao.addInstructor(instructor, instructorDetails);

        Instructor savedInstructor = instructorDao.getInstructor(instructorId);

        // explicitly assigning instructor to a course, from courses side
        Course javaCourse = Course.builder().title("Java").instructor(savedInstructor).build();

        CourseDao courseDao = new CourseDao();

        courseDao.addCourse(javaCourse);

        Course sqlCourse = Course.builder().title("Sql").build();

        // encapsulating adding course to instructor
        instructorDao.addInstructorCourse(instructor, sqlCourse);

        Course phpCourse = Course.builder().title("PHP").build();

        instructorDao.addInstructorCourse(instructor, phpCourse);
    }
}
