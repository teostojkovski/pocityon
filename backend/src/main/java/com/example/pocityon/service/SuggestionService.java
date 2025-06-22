package com.example.pocityon.service;

import com.example.pocityon.model.Suggestion;
import com.example.pocityon.request.CreateSuggestionRequest;

import java.util.List;

public interface SuggestionService {
    List<Suggestion> getAllSuggestions();
    Suggestion getSuggestionById(Long id);
    Suggestion createSuggestion(CreateSuggestionRequest req);
    Suggestion updateSuggestion(Long id, CreateSuggestionRequest req);
    void deleteSuggestion(Long id);
    List<Suggestion> getSuggestionsByCity(Long cityId);
    List<Suggestion> getSuggestionsByPlace(Long placeId);
    List<Suggestion> getSuggestionsByUser(Long userId);
    List<Suggestion> getSuggestionsByCategory(Long categoryId);
}
