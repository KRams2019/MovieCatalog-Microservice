package com.example.moviecataloginfo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moviecataloginfo.entity.CatalogItem;
import com.example.moviecataloginfo.entity.Movie;
import com.example.moviecataloginfo.entity.MovieAvgRating;
import com.example.moviecataloginfo.entity.UserRating;
import com.example.moviecataloginfo.service.MovieInfoService;
import com.example.moviecataloginfo.service.UserRatingInfoService;

@RestController
@RequestMapping("/catalog")
public class MovieInfoController {

	@Autowired
	RestTemplate resttemplate;

	@Autowired
	private MovieInfoService movieInfoService;

	@Autowired
	private UserRatingInfoService userRatingInfoService;

	@GetMapping("/mv-info")
	public String getMovieInfo() {
		// System.out.println("Got Hit!!");
		return "<h1>"+resttemplate.getForObject("http://movie-info-service:8080/movieinfo/hello", String.class)+"</h1>";
	}

	@GetMapping("/rt-data")
	public String getRatingInfo() {
		// System.out.println("Got Hit!!");
		return "<h1>"+resttemplate.getForObject("http://ratings-data-service:8081/ratingsdata/hello", String.class)+"</h1>";
	}

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") int userId) {

		UserRating userRating = userRatingInfoService.getUserRating(userId);
		return userRating.getRatings().stream().map(rating -> movieInfoService.getCatalogItem(rating))
				.collect(Collectors.toList());
	}

	@GetMapping("/allmovies")
	public List<MovieAvgRating> getMovieCatalog() {
		System.err.println("Controler!!");
		return movieInfoService.getMovieCatalog();
	}

	@PostMapping("/addmovie")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieInfoService.addMovie(movie);
	}

}
