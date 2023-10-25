package photocurator.palagimademeupload.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {

    @Id
    private Long id;
    private String imagePath;
    private String studentName;
    private Long studentId;
    private String title;
    private String description;
    private LocalDateTime dateSubmitted;
    private LocalDateTime timeSubmitted;
}
