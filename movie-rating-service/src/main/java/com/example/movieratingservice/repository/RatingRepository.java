package com.example.movieratingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movieratingservice.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating,Integer>{

}
