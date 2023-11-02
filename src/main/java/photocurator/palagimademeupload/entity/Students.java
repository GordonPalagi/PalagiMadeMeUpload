package photocurator.palagimademeupload.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDateTime dateRegistered;
    private LocalDateTime timeRegistered;

}


//    CREATE TABLE Students (
//        id BIGSERIAL PRIMARY KEY, -- Auto incrementing ID
//        username TEXT NOT NULL,
//        password TEXT NOT NULL,
//        email TEXT NOT NULL,
//        dateRegistered TIMESTAMP,
//        timeRegistered TIMESTAMP
//);