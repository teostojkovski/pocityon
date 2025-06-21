package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String icon;

    @OneToMany(mappedBy = "category")
    private List<Suggestion> suggestions;
}
