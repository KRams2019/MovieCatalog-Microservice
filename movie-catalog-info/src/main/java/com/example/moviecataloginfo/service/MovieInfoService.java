package com.example.moviecataloginfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.moviecataloginfo.entity.CatalogItem;
import com.example.moviecataloginfo.entity.Movie;
import com.example.moviecataloginfo.entity.MovieAvgRating;
import com.example.moviecataloginfo.entity.Rating;
import org.springframework.core.ParameterizedTypeReference;

@Service
public class MovieInfoService {

	@Autowired
	RestTemplate restTemplate;
	
	private final String movieUrl = "http://movie-info-service:8080/movieinfo/";

	
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject(movieUrl + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	}
	public List<MovieAvgRating> getMovieCatalog() {
		List<Rating> ratingList;
		List<Movie> movieList;

		ratingList = getRatingResponse();
		movieList = getMovieResponse();
		double rating = 0;
		List<MovieAvgRating> movieAvgRatingList = new ArrayList<MovieAvgRating>();
		int cnt = 0;
		for (int j = 0; j < movieList.size(); j++) {

			MovieAvgRating movieAvgRating = new MovieAvgRating();
			for (int i = 0; i < ratingList.size(); i++) {
				if (ratingList.get(i).getMovieId() == movieList.get(j).getMovieId()) {
					rating += ratingList.get(i).getRating();
					cnt++;
				}

			}
			rating = rating / cnt;
			movieAvgRating.setMovieId(movieList.get(j).getMovieId());
			movieAvgRating.setMovieName(movieList.get(j).getName());
			movieAvgRating.setDescription(movieList.get(j).getDescription());
			movieAvgRating.setRating(rating);
			movieAvgRatingList.add(movieAvgRating);
			cnt = 0;
			rating = 0;
		}
		return movieAvgRatingList;
	}

	public List<Rating> getRatingResponse() {

		ResponseEntity<List<Rating>> ratingResponse = restTemplate.exchange(
				"http://ratings-data-service:8081/ratingsdata/rating", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Rating>>() {

				});
		return ratingResponse.getBody();

	}

	public List<Movie> getMovieResponse() {


		ResponseEntity<List<Movie>> movieResponse = restTemplate.exchange("http://movie-info-service:8080/movieinfo/getAll",HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {});
		return movieResponse.getBody();
		
	}

	public Movie addMovie(Movie movie) {
		System.out.println(movieUrl);
		Movie returnMovie = restTemplate.postForObject(movieUrl + "addmovie", movie, Movie.class);
		return returnMovie;
	}

}
