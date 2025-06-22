package com.example.pocityon.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    private String url;
    private String description;
    @ManyToOne
    @JsonBackReference(value = "place-images")
    private Place place;
    @ManyToOne
    @JsonBackReference(value = "city-images")
    private City city;
} 