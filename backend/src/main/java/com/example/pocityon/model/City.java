package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private double latitude;
    private double longitude;
    private String coverImage;

    @OneToMany(mappedBy = "city")
    private List<Place> places;

    @OneToMany(mappedBy = "city")
    private List<Image> images;

    @OneToMany(mappedBy = "city")
    private List<Suggestion> suggestions;

    @OneToMany(mappedBy = "city")
    private List<Post> posts;
}
