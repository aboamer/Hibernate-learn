package hibernate;

import hibernate.dao.StudentDao;
import hibernate.entities.Student;

public class Test {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();

        Student student = Student.builder().firstName("Ramesh").lastName("Fadatare").email("ramesh@gmail.com").build();

        studentDao.addStudent(student);

        System.out.println("Done ------- " + student.getId());
    }
}
