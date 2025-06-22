package com.example.pocityon.repository;

import com.example.pocityon.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCityId(Long cityId);
    List<Post> findAllByPlaceId(Long placeId);
    List<Post> findAllByUserId(Long userId);

}
