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

    @ManyToOne
    private City city;

    @ManyToOne
    private Category category;

    @OneToOne(mappedBy = "place", cascade = CascadeType.ALL)
    private Sticker sticker;

    private List<String> images;

    @OneToMany(mappedBy = "place")
    private List<Suggestion> suggestions;
}
