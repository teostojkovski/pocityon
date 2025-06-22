package com.example.pocityon.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Data
@Entity
public class Place {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String phone;
    private String websiteUrl;
    private String openingHours;
    private String priceRange;
    private String phoneNumber;
    private String logo;
    private String address;
    private double latitude;
    private double longitude;

    @ManyToOne
    @JsonBackReference(value = "city-places")
    private City city;

    @ManyToOne
    @JsonBackReference(value = "category-places")
    private Category category;

    @OneToMany(mappedBy = "place")
    @JsonManagedReference(value = "place-images")
    private List<Image> images;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "place-suggestions")
    private List<Suggestion> suggestions;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "place-posts")
    private List<Post> posts;
}
