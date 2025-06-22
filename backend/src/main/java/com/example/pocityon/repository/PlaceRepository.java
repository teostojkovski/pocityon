package com.example.pocityon.repository;

import com.example.pocityon.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByCityId(Long cityId);
    List<Place> findAllByCategoryId(Long categoryId);
}
