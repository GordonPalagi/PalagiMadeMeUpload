package photocurator.palagimademeupload.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

}


//    CREATE TABLE Students (
//        id BIGSERIAL PRIMARY KEY, -- Auto incrementing ID
//        username TEXT NOT NULL,
//        password TEXT NOT NULL,
//        email TEXT NOT NULL,
//        dateRegistered TIMESTAMP,
//        timeRegistered TIMESTAMP
//);