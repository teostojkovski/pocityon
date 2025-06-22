package com.example.pocityon.request;

import com.example.pocityon.model.Category;
import com.example.pocityon.model.City;
import com.example.pocityon.model.Place;
import com.example.pocityon.model.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateSuggestionRequest {
    private String title;
    private String content;
    private String type;
    private String link;
    private LocalDateTime createdAt;
    private Long userId;
    private Long placeId;
    private Long categoryId;
    private Long cityId;
}
