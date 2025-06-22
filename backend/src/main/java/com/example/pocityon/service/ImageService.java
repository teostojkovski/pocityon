package com.example.pocityon.service;

import com.example.pocityon.model.Image;
import com.example.pocityon.request.CreateImageRequest;

import java.util.List;

public interface ImageService {
    List<Image> getAllImages();
    List<Image> getImagesByPlace(Long placeId);
    Image getImageById(Long id);
    Image createImage(CreateImageRequest req);
    Image updateImage(Long id, CreateImageRequest req);
    void deleteImage(Long id);
}
