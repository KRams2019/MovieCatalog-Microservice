package com.example.movieratingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movieratingservice.entity.UserRating;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating, Integer>{

	
}
