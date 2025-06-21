package com.example.pocityon.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Place {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String address;
    private double latitude;
    private double longitude;
    private String contactInfo;
    private String websiteUrl;
    private String openingHours;
    private String priceRange;
    private String phoneNumber;

    @ManyToOne
    private City city;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "place")
    private List<Image> images;

    @OneToMany(mappedBy = "place")
    private List<Suggestion> suggestions;
}
