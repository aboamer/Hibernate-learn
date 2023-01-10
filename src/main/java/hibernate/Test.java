package hibernate;

import hibernate.dao.StudentDao;
import hibernate.entities.Student;

public class Test {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();

        Student student = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");

        studentDao.addStudent(student);

        System.out.println(student.getId());
    }
}
