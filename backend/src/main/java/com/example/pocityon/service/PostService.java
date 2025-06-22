package com.example.pocityon.service;

import com.example.pocityon.model.Post;
import com.example.pocityon.request.CreatePostRequest;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post createPost(CreatePostRequest req);
    Post updatePost(Long id, CreatePostRequest req);
    void deletePost(Long id);
    List<Post> getPostsByCityId(Long cityId);
    List<Post> getPostsByPlaceId(Long placeId);
    List<Post> getPostsByUserId(Long userId);
}
