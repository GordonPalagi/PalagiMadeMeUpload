package photocurator.palagimademeupload.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Builder
@Data
public class UserDTO {

    private UUID id;

    private String bio;

    private Integer version;

    @NotNull
    private String name;

}
