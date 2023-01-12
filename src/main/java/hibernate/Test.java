package hibernate;

import hibernate.dao.InstructorDao;
import hibernate.dao.StudentDao;
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

        instructorDao.addInstructor(instructor, instructorDetails);
    }
}
