package com.example.pocityon.controller;

import com.example.pocityon.model.City;
import com.example.pocityon.repository.CityRepository;
import com.example.pocityon.request.CreateCityRequest;
import com.example.pocityon.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping
    public City createCity(@RequestBody CreateCityRequest req) {
        return cityService.createCity(req);
    }

    @PutMapping("/{id}")
    public void updateCity(@PathVariable Long id,
                           @RequestBody CreateCityRequest req) throws Exception {
        cityService.updateCity(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteCityById(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}
