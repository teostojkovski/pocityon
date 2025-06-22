package com.example.pocityon.controller;

import com.example.pocityon.model.Place;
import com.example.pocityon.request.CreatePlaceRequest;
import com.example.pocityon.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    private final PlaceService placeService;


    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public Place getPlaceById(@PathVariable Long id){
        return placeService.getPlaceById(id);
    }

    @GetMapping("/city/{cityId}")
    public List<Place> getPlacesByCity(@PathVariable Long cityId){
        return placeService.getPlacesByCity(cityId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Place> getPlacesByCategory(@PathVariable Long categoryId){
        return placeService.getPlacesByCategory(categoryId);
    }

    @PostMapping
    public Place createPlace(@RequestBody CreatePlaceRequest req){
        return placeService.createPlace(req);
    }

    @PutMapping("/{id}")
    public Place updatePlace(@PathVariable Long id,
                             @RequestBody CreatePlaceRequest req){
        return placeService.updatePlace(id, req);
    }

    @DeleteMapping("/{id}")
    public void deletePlace(@PathVariable Long id){
        placeService.deletePlace(id);
    }
}
