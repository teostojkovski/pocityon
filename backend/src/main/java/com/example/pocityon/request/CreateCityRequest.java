package com.example.pocityon.request;

import com.example.pocityon.model.Image;
import com.example.pocityon.model.Place;
import com.example.pocityon.model.Post;
import com.example.pocityon.model.Suggestion;
import lombok.Data;

import java.util.List;

@Data
public class CreateCityRequest {
    private Long id;
    private String name;
    private String description;
    private double latitude;
    private double longitude;
    private String coverImage;
    private List<Place> places;
    private List<Image> images;
    private List<Suggestion> suggestions;
    private List<Post> posts;
}
