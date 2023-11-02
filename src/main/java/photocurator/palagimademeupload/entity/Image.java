package photocurator.palagimademeupload.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    private Long id;
    private String studentName;
    private String imageUrl;
    @Column(length = 50)
    @Size(max = 50)
    private String title;
    private String description;
    private LocalDateTime dateSubmitted;
    private LocalDateTime timeSubmitted;

}
