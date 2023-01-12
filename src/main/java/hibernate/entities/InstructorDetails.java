package hibernate.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "instructor_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstructorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel", length = 128)
    private String youtubeChannel;

    @Column(name = "hobby", length = 45)
    private String hobby;

    // if optional is false and the other side is the owner, it will throw an exception
    // mapped by tells hibernate: go to instructorDetails in Instructor class - use info from Instructor class @JoinColumn to find associated Instructor
    @OneToOne(mappedBy = "instructorDetails")
    private Instructor instructor;
}
