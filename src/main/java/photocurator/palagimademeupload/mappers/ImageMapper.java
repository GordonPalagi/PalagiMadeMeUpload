package photocurator.palagimademeupload.mappers;

import org.mapstruct.Mapper;
import photocurator.palagimademeupload.entity.Image;
import photocurator.palagimademeupload.model.ImageDTO;

@Mapper
public interface ImageMapper{
    Image imageDtoToImage(ImageDTO dto);

    ImageDTO imageToImageDTO(Image img);
}
