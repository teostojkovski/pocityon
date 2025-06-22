package com.example.pocityon.model;

import jakarta.persistence.*;
import lombok.Data;

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
    private City city;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "place")
    private List<Image> images;

    @OneToMany(mappedBy = "place")
    private List<Suggestion> suggestions;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Post> posts;
}
