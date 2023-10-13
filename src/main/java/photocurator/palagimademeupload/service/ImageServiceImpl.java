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
        addImage(imagePath.building1, imagePath.description1, imagePath.title1, "Alex Johnson");
        addImage(imagePath.building2, imagePath.description2, imagePath.title2, "Jamie Smith");
        addImage(imagePath.building3, imagePath.description3, imagePath.title3, "Chris Lee");
        addImage(imagePath.building4, imagePath.description4, imagePath.title4, "Taylor Brown");
        addImage(imagePath.building5, imagePath.description5, imagePath.title5, "Jordan Garcia");
        addImage(imagePath.building6, imagePath.description6, imagePath.title6, "Morgan Davis");
        addImage(imagePath.building7, imagePath.description7, imagePath.title7, "Casey Rodriguez");
        addImage(imagePath.building8, imagePath.description8, imagePath.title8, "Riley Martinez");
        addImage(imagePath.building9, imagePath.description9, imagePath.title9, "Jordan Wilson");
        addImage(imagePath.building10, imagePath.description10, imagePath.title10, "Alexis Taylor");
    }

    private void addImage(String imagePath, String description, String title, String studentName) {
        ImageDTO image = ImageDTO.builder()
                .id(UUID.randomUUID())
                .imagePath(imagePath)
                .description(description)
                .studentName(studentName)
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
