package com.example.pocityon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
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

    private String image;

    private String bio;
    private String socialLinks;
    private int reputation;

}
