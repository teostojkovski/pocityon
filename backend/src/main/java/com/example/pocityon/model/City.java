package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonManagedReference(value = "city-places")
    private List<Place> places;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference(value = "city-images")
    private List<Image> images;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference(value = "city-suggestions")
    private List<Suggestion> suggestions;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference(value = "city-posts")
    private List<Post> posts;
}
