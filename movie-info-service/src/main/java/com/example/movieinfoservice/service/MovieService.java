package com.example.movieinfoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieinfoservice.entity.Movie;
import com.example.movieinfoservice.repository.MovieRepository;

@Service
public class MovieService {

	
	@Autowired
	MovieRepository movieRepository;
	
	public Movie getMovieInfo(int movieId) {
		Movie movie=movieRepository.findById(movieId).get();
		return movie;
	}
	
	public List<Movie> getAllMovieInfo() {
		List<Movie> movieList = movieRepository.findAll();
		return movieList;
	}
	
	public Movie addMovie(Movie movie) {
		System.err.println(movie.getName()+movie.getDescription());
		return movieRepository.save(movie);
	}
	
}
