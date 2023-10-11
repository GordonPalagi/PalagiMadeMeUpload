package photocurator.palagimademeupload.service;

import photocurator.palagimademeupload.model.ImageDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageService {
    List<ImageDTO> listImages();

    Optional<ImageDTO> findImageById(UUID uuid);

    ImageDTO saveImage(ImageDTO imageDTO);

    Optional<ImageDTO> updateBeerById(UUID imageId, ImageDTO image);

    Boolean deleteById(UUID id);


}
