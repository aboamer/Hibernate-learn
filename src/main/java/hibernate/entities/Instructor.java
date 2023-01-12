package hibernate.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // JoinColumn decides the owning side, which is Instructor
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_details_id", referencedColumnName = "id")
    private InstructorDetails instructorDetails;

    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses;

    /**
     *
     * encapsulating the relation between instructor and course
     */
    public void addCourse(Course course) {

        if(courses == null) {

            courses = new ArrayList<>();
        }

        courses.add(course);
        course.setInstructor(this);
    }
}
