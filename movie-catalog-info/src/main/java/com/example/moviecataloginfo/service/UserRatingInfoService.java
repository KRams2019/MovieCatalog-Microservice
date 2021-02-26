package com.example.moviecataloginfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.moviecataloginfo.entity.UserRating;

@Service
public class UserRatingInfoService {
	
	@Autowired
	RestTemplate restTemplate;
	
	private final String  ratingUrl="http://ratings-data-service :8081/ratingsdata/";

	public UserRating getUserRating(int userId) {
		 UserRating userRating = restTemplate.getForObject(ratingUrl+"user/"+userId, UserRating.class);
		 return userRating;
	}
	
	public UserRating getAddUser(UserRating rating) {
		 UserRating userRating = restTemplate.postForObject(ratingUrl,rating ,UserRating.class);
		 return userRating;
	}
}
