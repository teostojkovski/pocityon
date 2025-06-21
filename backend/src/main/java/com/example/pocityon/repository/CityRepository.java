package com.example.pocityon.repository;

import com.example.pocityon.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
