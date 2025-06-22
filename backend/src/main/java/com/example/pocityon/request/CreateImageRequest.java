package com.example.pocityon.request;

import lombok.Data;

@Data
public class CreateImageRequest {
    private String url;
    private String description;
    private Long placeId;
    private Long cityId;
}
