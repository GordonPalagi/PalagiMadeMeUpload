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
public class NotesDTO {

    @Id
    private Long noteId;
    private String noteTitle;
    private String noteContent;
    private String noteDate;
    private String noteTime;

}
