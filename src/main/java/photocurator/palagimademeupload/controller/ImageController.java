package photocurator.palagimademeupload.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import photocurator.palagimademeupload.model.ImageDTO;
import photocurator.palagimademeupload.service.ImageService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping(value = "/api/v1/images")
    public @ResponseBody List<ImageDTO> getImages() {
        return imageService.listImages();
    }

    @GetMapping(value ="/api/v1/images/{id}")
    public ImageDTO getImageById(@PathVariable("id") UUID id) {
        return imageService.findImageById(id).orElseThrow();
    }


}
