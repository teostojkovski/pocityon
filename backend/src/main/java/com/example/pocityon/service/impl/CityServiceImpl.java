package com.example.pocityon.service.impl;

import com.example.pocityon.model.City;
import com.example.pocityon.repository.CityRepository;
import com.example.pocityon.request.CreateCityRequest;
import com.example.pocityon.service.CityService;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id: " + id));
    }

    @Override
    public City createCity(CreateCityRequest req) {
        City city = new City();
        city.setName(req.getName());
        city.setDescription(req.getDescription());
        city.setLatitude(req.getLatitude());
        city.setLongitude(req.getLongitude());
        city.setCoverImage(req.getCoverImage());
        city.setPlaces(req.getPlaces());
        city.setImages(req.getImages());
        city.setPosts(req.getPosts());
        city.setSuggestions(req.getSuggestions());
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(Long id, CreateCityRequest req) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id: " + id));
        city.setName(req.getName());
        city.setDescription(req.getDescription());
        city.setLatitude(req.getLatitude());
        city.setLongitude(req.getLongitude());
        city.setCoverImage(req.getCoverImage());
        city.setPlaces(req.getPlaces());
        city.setImages(req.getImages());
        city.setPosts(req.getPosts());
        city.setSuggestions(req.getSuggestions());
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
