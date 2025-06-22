package com.example.pocityon.service.impl;

import com.example.pocityon.model.*;
import com.example.pocityon.repository.*;
import com.example.pocityon.request.CreateSuggestionRequest;
import com.example.pocityon.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final CityRepository cityRepository;
    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public SuggestionServiceImpl(SuggestionRepository suggestionRepository, CityRepository cityRepository, PlaceRepository placeRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.suggestionRepository = suggestionRepository;
        this.cityRepository = cityRepository;
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Suggestion> getAllSuggestions() {
        return suggestionRepository.findAll();
    }

    @Override
    public Suggestion getSuggestionById(Long id) {
        return suggestionRepository.findById(id).orElseThrow();
    }

    @Override
    public Suggestion createSuggestion(CreateSuggestionRequest req) {
        City city = cityRepository.findById(req.getCityId()).orElseThrow();
        Place place = placeRepository.findById(req.getPlaceId()).orElseThrow();
        User user = userRepository.findById(req.getUserId()).orElseThrow();
        Category category = categoryRepository.findById(req.getCategoryId()).orElseThrow();
        Suggestion suggestion = new Suggestion();

        suggestion.setTitle(req.getTitle());
        suggestion.setContent(req.getContent());
        suggestion.setType(req.getType());
        suggestion.setLink(req.getLink());
        suggestion.setCreatedAt(LocalDateTime.now());
        suggestion.setAuthor(user);
        suggestion.setCity(city);
        suggestion.setPlace(place);
        suggestion.setCategory(category);
        return suggestionRepository.save(suggestion);
    }

    @Override
    public Suggestion updateSuggestion(Long id, CreateSuggestionRequest req) {
        Suggestion suggestion = suggestionRepository.findById(id).orElseThrow();
        City city = cityRepository.findById(req.getCityId()).orElseThrow();
        User user = userRepository.findById(req.getUserId()).orElseThrow();
        Category category = categoryRepository.findById(req.getCategoryId()).orElseThrow();
        Place place = null;
        if (req.getPlaceId() != null) {
            place = placeRepository.findById(req.getPlaceId()).orElseThrow();
        }

        suggestion.setTitle(req.getTitle());
        suggestion.setContent(req.getContent());
        suggestion.setType(req.getType());
        suggestion.setLink(req.getLink());
        suggestion.setCreatedAt(LocalDateTime.now());
        suggestion.setAuthor(user);
        suggestion.setCity(city);
        suggestion.setPlace(place);
        suggestion.setCategory(category);
        return suggestionRepository.save(suggestion);
    }

    @Override
    public void deleteSuggestion(Long id) {
        suggestionRepository.deleteById(id);
    }

    @Override
    public List<Suggestion> getSuggestionsByCity(Long cityId) {
        return suggestionRepository.findAllByCityId(cityId);
    }

    @Override
    public List<Suggestion> getSuggestionsByPlace(Long placeId) {
        return suggestionRepository.findAllByPlaceId(placeId);
    }

    @Override
    public List<Suggestion> getSuggestionsByUser(Long userId) {
        return suggestionRepository.findAllByUserId(userId);
    }

    @Override
    public List<Suggestion> getSuggestionsByCategory(Long categoryId) {
        return suggestionRepository.findAllByCategoryId(categoryId);
    }
}
