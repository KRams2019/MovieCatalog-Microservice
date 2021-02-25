package com.example.movieratingservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class RatingDto {
	

	private int ratingId;
	private int movieId;
	private int rating;

	@JsonIgnoreProperties("ratings")
	private UserRatingDto userRating;

	public RatingDto() {
		super();
	}

	public RatingDto(int ratingId, int movieId, int rating, UserRatingDto userRating) {
		super();
		this.ratingId = ratingId;
		this.movieId = movieId;
		this.rating = rating;
		this.userRating = userRating;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public UserRatingDto getUserRating() {
		return userRating;
	}

	public void setUserRating(UserRatingDto userRating) {
		this.userRating = userRating;
	}

}
