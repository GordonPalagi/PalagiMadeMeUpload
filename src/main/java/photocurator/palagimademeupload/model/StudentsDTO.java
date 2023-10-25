package photocurator.palagimademeupload.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentsDTO {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;

}
