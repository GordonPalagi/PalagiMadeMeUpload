package photocurator.palagimademeupload.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class ImageMetadataDTO {

    private UUID id;
    private String title;
    private String description;
    private String dateSubmitted;
    private String timeSubmitted;

}
