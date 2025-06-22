package com.example.pocityon.controller;

import com.example.pocityon.model.Post;
import com.example.pocityon.request.CreatePostRequest;
import com.example.pocityon.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @GetMapping("/city/{cityId}")
    public List<Post> getPostsByCity(@PathVariable Long cityId){
        return postService.getPostsByCityId(cityId);
    }

    @GetMapping("/place/{placeId}")
    public List<Post> getPostsByPlace(@PathVariable Long placeId){
        return postService.getPostsByPlaceId(placeId);
    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUser(@PathVariable Long userId){
        return postService.getPostsByUserId(userId);
    }

    @PostMapping
    public Post createPost(@RequestBody CreatePostRequest req){
        return postService.createPost(req);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id,
                           @RequestBody CreatePostRequest req){
        return postService.updatePost(id, req);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
