package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Sticker {

    @Id
    @GeneratedValue
    private Long id;

    private String patternSeed;
    private String style;
    private String svgData;

    @OneToOne
    private Place place;

}
