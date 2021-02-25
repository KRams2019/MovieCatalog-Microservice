package com.example.movieratingservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieratingservice.dto.RatingDto;
import com.example.movieratingservice.dto.UserRatingDto;
import com.example.movieratingservice.entity.Rating;
import com.example.movieratingservice.entity.UserRating;
import com.example.movieratingservice.repository.RatingRepository;
import com.example.movieratingservice.repository.UserRatingRepository;

@Service
public class RatingDataService {
	
	ModelMapper modelMapper=new ModelMapper();

	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	UserRatingRepository userRatingRepository;
	
	public RatingDto getMovieRating(int movieId) {
		Rating rating= ratingRepository.findById(movieId).get();
		//System.out.println(rating.getRatingId());
		return convertEntityToDto(rating);
	}
	
	public UserRatingDto getUserRatings(int userId) {
		UserRatingDto userDto=new UserRatingDto();
		List<Rating> ratings= userRatingRepository.findById(userId).get().getRatings();
		List<RatingDto> ratingDtoList=ratings.stream().map(entity->convertEntityToDto(entity)).collect(Collectors.toList());
		userDto.setName(userRatingRepository.findById(userId).get().getName());
		userDto.setUserId(userId);
		userDto.setRatings(ratingDtoList);
		return userDto;
	}
	
	public List<RatingDto> getAvgRatings() {
		List<Rating> ratings= ratingRepository.findAll();
		List<RatingDto> ratingDtoList=ratings.stream().map(entity->convertEntityToDto(entity)).collect(Collectors.toList());
		//RatingListDto ratingListDto=new RatingListDto();
		//ratingListDto.setRatingDto(ratingDtoList);
		return ratingDtoList;
		
	}
	
	public UserRatingDto adduserRating(UserRatingDto userRatingDto) {
		//userRating = new UserRating(userId, name, ratings);
				
		UserRating userRating = convertDtoToEntity(userRatingDto);
		return convertEntityToDto(userRatingRepository.save(userRating));
	}
	
	public RatingDto addRating(RatingDto ratingDto) {
		
		//rating = new Rating(ratingId, movieId, rating, userRating);
		Rating rating = convertDtoToEntity(ratingDto);
		RatingDto getRatingDto= convertEntityToDto(ratingRepository.save(rating));
		return getRatingDto;
	}
	
	public RatingDto convertEntityToDto(Rating rating) {
		return modelMapper.map(rating,RatingDto.class);
	}
	
	public UserRatingDto convertEntityToDto(UserRating rating) {
		return modelMapper.map(rating,UserRatingDto.class);
	}
	
	
	public Rating convertDtoToEntity(RatingDto rating) {
		return modelMapper.map(rating,Rating.class);
	}
	
	public UserRating convertDtoToEntity(UserRatingDto rating) {
		return modelMapper.map(rating,UserRating.class);
	}

}
