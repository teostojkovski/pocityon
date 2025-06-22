package com.example.pocityon.repository;

import com.example.pocityon.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByPlaceId(Long placeId);
}
