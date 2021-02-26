package com.example.moviecataloginfo.entity;

public class Rating {

	private int ratingId;
	private int movieId;
	private int rating;

	private UserRating userRating;

	public Rating() {

	}

	public Rating(int ratingId, int movieId, int rating, UserRating userRating) {
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

	public UserRating getUserRating() {
		return userRating;
	}

	public void setUserRating(UserRating userRating) {
		this.userRating = userRating;
	}

}
