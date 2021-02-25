package com.example.movieinfoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.movieinfoservice.entity.Movie;
import com.example.movieinfoservice.service.MovieService;

@RestController
@RequestMapping("/movieinfo")
public class MovieController {

	 @Autowired
	 private MovieService movieService;
	 
	@GetMapping("/{movieId}")
	 public Movie getMovieInfo(@PathVariable("movieId") int movieId) {
	        //MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
		 return movieService.getMovieInfo(movieId);
	 }
	 
	 @GetMapping("/getAll")
	 public List<Movie> getMovieInfoList() {
	        //MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
		 return movieService.getAllMovieInfo();
	 }
	 
	 @PostMapping("/addmovie")
	 public Movie addMovie(@RequestBody Movie movie) {
		 return movieService.addMovie(movie);
	 }
	 
	 @GetMapping("/hello")
	 public String getHello() {
		 return "Movie-Service";
	 }
	 
	
}
