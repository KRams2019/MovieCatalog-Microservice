package com.example.movieratingservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserRatingDto {
	

	private int userId;
	private String name;

	@JsonIgnoreProperties("userRating")
	private List<RatingDto> ratings;

	public UserRatingDto() {
		super();
	}

	public UserRatingDto(int userId, String name, List<RatingDto> ratings) {
		super();
		this.userId = userId;
		this.name = name;
		this.ratings = ratings;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RatingDto> getRatings() {
		return ratings;
	}

	public void setRatings(List<RatingDto> ratings) {
		this.ratings = ratings;
	}

}
