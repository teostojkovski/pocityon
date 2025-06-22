package com.example.pocityon.request;

import com.example.pocityon.model.Post;
import com.example.pocityon.model.Suggestion;
import com.example.pocityon.model.UserRole;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserRequest {
    private String username;
    private String email;
    private String password;
    private UserRole role;
    private String image;
    private String bio;
    private String socialLinks;
    private List<Post> posts;
    private List<Suggestion> suggestions;
}
