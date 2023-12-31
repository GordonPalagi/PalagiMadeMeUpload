package photocurator.palagimademeupload.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import photocurator.palagimademeupload.model.ImageDTO;
import photocurator.palagimademeupload.service.ImageService;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping(value ="/api/v1/images")
    public @ResponseBody List<ImageDTO> listImages() {
        return imageService.listImages();
    }

//    @GetMapping(value ="/api/v1/images/{id}")
//    public ImageDTO getImageById(@PathVariable("id") UUID id) {
//        return imageService.findImageById(id).orElseThrow();
//    }



}
