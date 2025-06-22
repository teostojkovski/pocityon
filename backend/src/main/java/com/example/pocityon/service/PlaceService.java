package com.example.pocityon.service;

import com.example.pocityon.model.Place;
import com.example.pocityon.request.CreatePlaceRequest;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();
    Place getPlaceById(Long id);
    Place createPlace(CreatePlaceRequest req);
    Place updatePlace(Long id, CreatePlaceRequest req);
    void deletePlace(Long id);
    List<Place> getPlacesByCity(Long cityId);
    List<Place> getPlacesByCategory(Long categoryId);
}
