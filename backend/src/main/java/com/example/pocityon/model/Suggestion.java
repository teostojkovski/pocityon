package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    private User author;

    @ManyToOne
    private Place place; // this is only if I tie the suggestion to a place.

    private String type;
    private LocalDateTime createdAt;

    @ManyToOne
    private Category category;
    @ManyToOne
    private City city;
}
