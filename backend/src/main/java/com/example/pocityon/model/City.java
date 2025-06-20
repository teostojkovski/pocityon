package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private double latitude;
    private double longitude;

    @OneToMany(mappedBy = "city")
    private List<Place> places;
}
