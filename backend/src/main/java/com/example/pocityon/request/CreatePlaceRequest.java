package com.example.pocityon.request;

import com.example.pocityon.model.*;
import lombok.Data;

import java.util.List;

@Data
public class CreatePlaceRequest {
    private String name;
    private String description;
    private String phone;
    private String websiteUrl;
    private String openingHours;
    private String priceRange;
    private String phoneNumber;
    private String logo;
    private String address;
    private double latitude;
    private double longitude;
    private Long cityId;
    private Long categoryId;
    private List<Image> images;
    private List<Suggestion> suggestions;
    private List<Post> posts;
}
