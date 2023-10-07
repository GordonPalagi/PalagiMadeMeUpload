package photocurator.palagimademeupload.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import photocurator.palagimademeupload.model.ImageDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {


    private final Map<UUID, ImageDTO> imageMap;

    public ImageServiceImpl() {
        this.imageMap = new HashMap<>();
    }

    public byte[] getImageBytes(String filePath) throws IOException {
        File file = new File(filePath);
        return IOUtils.toByteArray(new FileInputStream(file));
    }



    @PostConstruct
    public void init() throws IOException {
        File file1 = new File("src/main/resources/assets/download.jpeg");
        File file2 = new File("src/main/resources/assets/download2.jpeg");

        addImage(String.valueOf(file1), "This is a picture of a cat", "Cat");
        addImage(String.valueOf(file2), "This is another cat", "Cat");
    }

    private void addImage(String imagePath, String description, String title) throws IOException {
        ImageDTO image = ImageDTO.builder()
                .id(UUID.randomUUID())
                .imageBytes(getImageBytes(imagePath))
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
                .imageBytes(imageDTO.getImageBytes())
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
        existingImage.setImageBytes(image.getImageBytes());
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
