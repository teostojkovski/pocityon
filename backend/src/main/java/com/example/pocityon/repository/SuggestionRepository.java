package com.example.pocityon.repository;

import com.example.pocityon.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
    List<Suggestion> findAllByCityId(Long cityId);
    List<Suggestion> findAllByPlaceId(Long placeId);
    List<Suggestion> findAllByUserId(Long userId);
    List<Suggestion> findAllByCategoryId(Long categoryId);
}