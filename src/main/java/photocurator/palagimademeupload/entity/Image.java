package photocurator.palagimademeupload.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Image {
    @Id
    // @GeneratedValue(generator = "UUID")
    // @GenericGenerator(name = "UUID", type = org.hibernate.id.uuid.UuidGenerator.class)
    // deprecated as of V 6.2. Use line above in normal context.
    // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    // @JdbcTypeCode(SqlTypes.CHAR)
    // @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    @NotBlank
    private String studentName;

    @NotNull
    @NotBlank
    private String imagePath;

    @NotNull
    @NotBlank
    @Column(length = 50)
    @Size(max = 50)
    private String title;

    @NotNull
    private String description;
    private LocalDateTime dateSubmitted;
    private LocalDateTime timeSubmitted;

}
