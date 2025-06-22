package com.example.pocityon.service.impl;

import com.example.pocityon.model.City;
import com.example.pocityon.model.Image;
import com.example.pocityon.model.Place;
import com.example.pocityon.repository.CityRepository;
import com.example.pocityon.repository.ImageRepository;
import com.example.pocityon.repository.PlaceRepository;
import com.example.pocityon.request.CreateImageRequest;
import com.example.pocityon.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final CityRepository cityRepository;
    private final PlaceRepository placeRepository;

    public ImageServiceImpl(ImageRepository imageRepository, CityRepository cityRepository, PlaceRepository placeRepository) {
        this.imageRepository = imageRepository;
        this.cityRepository = cityRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getImagesByPlace(Long placeId) {
        return imageRepository.findAllByPlaceId(placeId);
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElseThrow();
    }

    @Override
    public Image createImage(CreateImageRequest req) {
        City city = cityRepository.findById(req.getCityId()).orElseThrow();
        Place place = placeRepository.findById(req.getPlaceId()).orElseThrow();

        Image image = new Image();
        image.setUrl(req.getUrl());
        image.setDescription(req.getDescription());
        image.setPlace(place);
        image.setCity(city);
        return imageRepository.save(image);
    }

    @Override
    public Image updateImage(Long id, CreateImageRequest req) {
        City city = cityRepository.findById(req.getCityId()).orElseThrow();
        Place place = placeRepository.findById(req.getPlaceId()).orElseThrow();
        Image image = imageRepository.findById(id).orElseThrow();

        image.setUrl(req.getUrl());
        image.setDescription(req.getDescription());
        image.setPlace(place);
        image.setCity(city);
        return imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
