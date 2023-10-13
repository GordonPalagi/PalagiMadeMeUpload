package photocurator.palagimademeupload.model;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class ImageDTO {

    private UUID id;

    @NotNull
    @NotBlank
    private String imagePath;

    private String title;

    private String description;
    private LocalDateTime dateSubmitted;
    private LocalDateTime timeSubmitted;
}
