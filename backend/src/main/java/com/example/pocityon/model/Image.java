package com.example.pocityon.model;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    private String url;
    private String description;
    @ManyToOne
    private Place place;
    @ManyToOne
    private City city;
} 