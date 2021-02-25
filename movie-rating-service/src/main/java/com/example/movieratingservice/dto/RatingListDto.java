package com.example.movieratingservice.dto;

import java.util.List;

public class RatingListDto {

	private List<RatingDto> ratingDto;

	public RatingListDto() {
		super();
	}

	public RatingListDto(List<RatingDto> ratingDto) {
		super();
		this.ratingDto = ratingDto;
	}

	public List<RatingDto> getRatingDto() {
		return ratingDto;
	}

	public void setRatingDto(List<RatingDto> ratingDto) {
		this.ratingDto = ratingDto;
	}

}
