package com.example.pocityon.controller;

import com.example.pocityon.model.Image;
import com.example.pocityon.request.CreateImageRequest;
import com.example.pocityon.service.ImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public List<Image> getAllImages(){
        return imageService.getAllImages();
    }

    @GetMapping("/place/{placeId}")
    public List<Image> getImagesByPlace(@PathVariable Long placeId){
        return imageService.getImagesByPlace(placeId);
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Long id){
        return imageService.getImageById(id);
    }

    @PostMapping
    public Image createImage(@RequestBody CreateImageRequest req){
        return imageService.createImage(req);
    }

    @PutMapping("/{id}")
    public Image updateImage(@PathVariable Long id,
                             @RequestBody CreateImageRequest req){
        return imageService.updateImage(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id){
        imageService.deleteImage(id);
    }
}

