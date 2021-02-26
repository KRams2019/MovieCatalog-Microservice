package com.example.moviecataloginfo.entity;

public class MovieAvgRating {
	

	private double rating;
	private int movieId;
	private String movieName;
	private String description;
	
	
	public MovieAvgRating() {
		super();
	}


	public MovieAvgRating(double rating, int movieId, String movieName, String description) {
		super();
		this.rating = rating;
		this.movieId = movieId;
		this.movieName = movieName;
		this.description = description;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	

}
