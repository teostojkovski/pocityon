package com.example.pocityon.service.impl;

import com.example.pocityon.model.City;
import com.example.pocityon.model.Place;
import com.example.pocityon.model.Post;
import com.example.pocityon.model.User;
import com.example.pocityon.repository.CityRepository;
import com.example.pocityon.repository.PlaceRepository;
import com.example.pocityon.repository.PostRepository;
import com.example.pocityon.repository.UserRepository;
import com.example.pocityon.request.CreatePostRequest;
import com.example.pocityon.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CityRepository cityRepository;
    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, CityRepository cityRepository, PlaceRepository placeRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.cityRepository = cityRepository;
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }

    @Override
    public Post createPost(CreatePostRequest req) {
        City city = cityRepository.findById(req.getCityId()).orElseThrow();
        Place place = placeRepository.findById(req.getPlaceId()).orElseThrow();
        User user = userRepository.findById(req.getUserId()).orElseThrow();
        Post post = new Post();

        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        post.setCreatedAt(LocalDateTime.now());
        post.setCity(city);
        post.setPlace(place);
        post.setAuthor(user);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, CreatePostRequest req) {
        Post post = postRepository.findById(id).orElseThrow();
        City city = cityRepository.findById(req.getCityId()).orElseThrow();
        Place place = placeRepository.findById(req.getPlaceId()).orElseThrow();
        User user = userRepository.findById(req.getUserId()).orElseThrow();

        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        post.setCreatedAt(LocalDateTime.now());
        post.setCity(city);
        post.setPlace(place);
        post.setAuthor(user);
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getPostsByCityId(Long cityId) {
        return postRepository.findAllByCityId(cityId);
    }

    @Override
    public List<Post> getPostsByPlaceId(Long placeId) {
        return postRepository.findAllByPlaceId(placeId);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByAuthorId(userId);
    }
}
