package com.example.pocityon.service;

import com.example.pocityon.model.City;
import com.example.pocityon.request.CreateCityRequest;

import java.util.List;

public interface CityService {
    public List<City> getAllCities();
    public City getCityById(Long id);
    City createCity(CreateCityRequest createCityRequest);
    City updateCity(Long id, CreateCityRequest createCityRequest) throws Exception;
    void deleteCity(Long id);
}
