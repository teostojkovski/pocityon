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
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonBackReference(value = "user-posts")
    private User author;

    @ManyToOne
    @JsonBackReference(value = "city-posts")
    private City city;

    @ManyToOne
    @JsonBackReference(value = "place-posts")
    private Place place;
}
