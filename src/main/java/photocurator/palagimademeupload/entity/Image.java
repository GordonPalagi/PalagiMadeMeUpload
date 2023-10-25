package photocurator.palagimademeupload.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

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
    private String imagePath;
    @Column(length = 50)
    @Size(max = 50)
    private String title;
    private String description;
    private LocalDateTime dateSubmitted;
    private LocalDateTime timeSubmitted;

}
