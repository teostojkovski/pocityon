package com.example.pocityon.controller;

import com.example.pocityon.model.Suggestion;
import com.example.pocityon.request.CreateSuggestionRequest;
import com.example.pocityon.service.SuggestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping
    public List<Suggestion> getAllSuggestions(){
        return suggestionService.getAllSuggestions();
    }

    @GetMapping("/{id}")
    public Suggestion getSuggestionById(@PathVariable Long id){
        return suggestionService.getSuggestionById(id);
    }

    @GetMapping("/city/{cityId}")
    public List<Suggestion> getSuggestionsByCity(@PathVariable Long cityId){
        return suggestionService.getSuggestionsByCity(cityId);
    }

    @GetMapping("/place/{placeId}")
    public List<Suggestion> getSuggestionsByPlace(@PathVariable Long placeId){
        return suggestionService.getSuggestionsByPlace(placeId);
    }

    @GetMapping("/user/{userId}")
    public List<Suggestion> getSuggestionsByUser(@PathVariable Long userId){
        return suggestionService.getSuggestionsByUser(userId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Suggestion> getSuggestionsByCategory(@PathVariable Long categoryId){
        return suggestionService.getSuggestionsByCategory(categoryId);
    }

    @PostMapping
    public Suggestion createSuggestion(@RequestBody CreateSuggestionRequest req){
        return suggestionService.createSuggestion(req);
    }

    @PutMapping("/{id}")
    public Suggestion updateSuggestion(@PathVariable Long id,
                                       @RequestBody CreateSuggestionRequest req){
        return suggestionService.updateSuggestion(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteSuggestion(@PathVariable Long id){
        suggestionService.deleteSuggestion(id);
    }
}

