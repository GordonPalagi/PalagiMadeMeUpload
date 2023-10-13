package photocurator.palagimademeupload.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import photocurator.palagimademeupload.model.ImageDTO;
import photocurator.palagimademeupload.repository.ImagePathBuilder;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {


    private final Map<UUID, ImageDTO> imageMap;

    public ImageServiceImpl() {
        this.imageMap = new HashMap<>();
    }

    ImagePathBuilder imagePath = new ImagePathBuilder();

    @PostConstruct
    public void init() {
       addImage(imagePath.building1, "Falling Waters", "Building 1");
       addImage(imagePath.building2, "Syndey Opera House", "Building 2");
       addImage(imagePath.building3, "A Cat House", "Building 3");
       addImage(imagePath.building4, "Weird rounded buildings that are kinda cool", "Building 4");
       addImage(imagePath.building5, "A building that looks like a ship", "Building 5");
       addImage(imagePath.building6, "A building that looks different from the others", "Building 6");
       addImage(imagePath.building7, "A building that seems to be made of glass", "Building 7");
       addImage(imagePath.building8, "A building that doesn't look like a building", "Building 8");
       addImage(imagePath.building9, "A building that could be a church", "Building 9");
       addImage(imagePath.building10, "A building that looks like a building", "Building 10");
    }

    private void addImage(String imagePath, String description, String title) {
        ImageDTO image = ImageDTO.builder()
                .id(UUID.randomUUID())
                .imagePath(imagePath)
                .description(description)
                .title(title)
                .dateSubmitted(LocalDateTime.now())
                .timeSubmitted(LocalDateTime.now())
                .build();
        imageMap.put(image.getId(), image);
    }

    @Override
    public List<ImageDTO> listImages() {
        return new ArrayList<>(imageMap.values());
    }

    @Override
    public Optional<ImageDTO> findImageById(UUID uuid) {
        return Optional.ofNullable(imageMap.get(uuid));
    }

    @Override
    public ImageDTO saveImage(ImageDTO imageDTO) {

        ImageDTO savedImage = ImageDTO.builder()
                .id(UUID.randomUUID())
                .imagePath(imageDTO.getImagePath())
                .description(imageDTO.getDescription())
                .title(imageDTO.getTitle())
                .dateSubmitted(LocalDateTime.now())
                .timeSubmitted(LocalDateTime.now())
                .build();

        imageMap.put(savedImage.getId(), savedImage);

        return savedImage;
    }

    @Override
    public Optional<ImageDTO> updateBeerById(UUID imageId, ImageDTO image) {

        ImageDTO existingImage = imageMap.get(imageId);
        existingImage.setDescription(image.getDescription());
        existingImage.setDescription(image.getDescription());
        existingImage.setTitle(image.getTitle());
        existingImage.setDateSubmitted(image.getDateSubmitted());
        existingImage.setTimeSubmitted(image.getTimeSubmitted());

        return Optional.of(existingImage);
    }

    @Override
    public Boolean deleteById(UUID id) {
        imageMap.remove(id);

        return true;
    }
}
