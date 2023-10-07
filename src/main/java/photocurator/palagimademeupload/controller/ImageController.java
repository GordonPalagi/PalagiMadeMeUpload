package photocurator.palagimademeupload.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import photocurator.palagimademeupload.entity.Image;
import photocurator.palagimademeupload.model.ImageDTO;
import photocurator.palagimademeupload.model.ImageMetadataDTO;
import photocurator.palagimademeupload.service.ImageService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping(value ="/api/v1/images")
    public @ResponseBody List<ImageDTO> listImages() {
        return imageService.listImages();
    }

    @GetMapping(value ="/api/v1/images/{id}")
    public ImageDTO getImageById(@PathVariable("id") UUID id) {
        return imageService.findImageById(id).orElseThrow();
    }


}
