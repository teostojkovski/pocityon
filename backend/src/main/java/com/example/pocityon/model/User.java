package com.example.pocityon.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private  Long id;
    private String username;
    private String email;
    private String password;
    private UserRole role = UserRole.USER;
    private String image;
    private String bio;
    private String socialLinks;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-posts")
    private List<Post> posts;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference(value = "user-suggestions")
    private List<Suggestion> suggestions;
}
