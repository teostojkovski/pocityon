package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

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
    private User author;

    @ManyToOne
    private Place place; // this is only if I tie the suggestion to a place.

    @ManyToOne
    private Category category;

    @ManyToOne
    private City city;
}
