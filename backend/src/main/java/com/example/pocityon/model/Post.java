package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

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
    private User author;

    @ManyToOne
    private City city;

    @ManyToOne
    private Place place;
}
