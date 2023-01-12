package hibernate.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    String title;

    // we cannot save a course without instructor, so optional = false
    @ManyToOne(optional = false)
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    Instructor instructor;

    @ManyToMany
    @JoinTable(name = "courses_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    List<Student> students;
}
