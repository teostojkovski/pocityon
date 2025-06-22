package com.example.pocityon.service.impl;

import com.example.pocityon.model.Category;
import com.example.pocityon.model.City;
import com.example.pocityon.model.Place;
import com.example.pocityon.repository.CategoryRepository;
import com.example.pocityon.repository.CityRepository;
import com.example.pocityon.repository.PlaceRepository;
import com.example.pocityon.request.CreatePlaceRequest;
import com.example.pocityon.service.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;
    private final CityRepository cityRepository;
    private final CategoryRepository categoryRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository, CityRepository cityRepository, CategoryRepository categoryRepository) {
        this.placeRepository = placeRepository;
        this.cityRepository = cityRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public Place getPlaceById(Long id) {
        return placeRepository.findById(id).orElseThrow();
    }

    @Override
    public Place createPlace(CreatePlaceRequest req) {
        City city = cityRepository.findById(req.getCityId()).orElseThrow();
        Category category = categoryRepository.findById(req.getCategoryId()).orElseThrow();
        Place place = new Place();
        place.setName(req.getName());
        place.setDescription(req.getDescription());
        place.setPhone(req.getPhone());
        place.setWebsiteUrl(req.getWebsiteUrl());
        place.setOpeningHours(req.getOpeningHours());
        place.setPriceRange(req.getPriceRange());
        place.setLogo(req.getLogo());
        place.setAddress(req.getAddress());
        place.setLatitude(req.getLatitude());
        place.setLongitude(req.getLongitude());
        place.setCity(city);
        place.setCategory(category);
        place.setImages(req.getImages());
        place.setSuggestions(req.getSuggestions());
        return placeRepository.save(place);
    }

    @Override
    public Place updatePlace(Long id, CreatePlaceRequest req) {
        Place place = placeRepository.findById(id).orElseThrow();
        City city = cityRepository.findById(req.getCityId()).orElseThrow();
        Category category = categoryRepository.findById(req.getCategoryId()).orElseThrow();
        place.setName(req.getName());
        place.setDescription(req.getDescription());
        place.setPhone(req.getPhone());
        place.setWebsiteUrl(req.getWebsiteUrl());
        place.setOpeningHours(req.getOpeningHours());
        place.setPriceRange(req.getPriceRange());
        place.setLogo(req.getLogo());
        place.setAddress(req.getAddress());
        place.setLatitude(req.getLatitude());
        place.setLongitude(req.getLongitude());
        place.setCity(city);
        place.setCategory(category);
        place.setImages(req.getImages());
        place.setSuggestions(req.getSuggestions());
        return placeRepository.save(place);
    }

    @Override
    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public List<Place> getPlacesByCity(Long cityId) {
        return placeRepository.findAllByCityId(cityId);
    }

    @Override
    public List<Place> getPlacesByCategory(Long categoryId) {
        return placeRepository.findAllByCategoryId(categoryId);
    }
}
