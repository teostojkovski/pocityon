package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private  Long id;
    private String fullName;
    private String username;
    private String email;
    private String password;
    private UserRole role = UserRole.USER;

    @OneToMany(mappedBy = "author")
    private List<Suggestion> suggestions;

    @OneToMany(mappedBy = "owner")
    private List<Place> ownedPlaces;

    private String image;

}
