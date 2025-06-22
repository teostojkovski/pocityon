package com.example.pocityon.request;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String title;
    private String content;
    private Long userId;
    private Long cityId;
    private Long placeId;
}
