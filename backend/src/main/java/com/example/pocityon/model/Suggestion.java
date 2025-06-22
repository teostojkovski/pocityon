package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDateTime;

@Data
@Entity
public class Suggestion {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String type;    //optional
    private String link;    //optional
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonBackReference(value = "user-suggestions")
    private User author;

    @ManyToOne
    @JsonBackReference(value = "place-suggestions")
    private Place place;

    @ManyToOne
    @JsonBackReference(value = "category-suggestions")
    private Category category;

    @ManyToOne
    @JsonBackReference(value = "city-suggestions")
    private City city;
}
