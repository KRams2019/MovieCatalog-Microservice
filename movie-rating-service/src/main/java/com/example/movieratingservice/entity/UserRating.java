package com.example.movieratingservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserRating {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	private String name;

	@OneToMany(mappedBy = "userRating")
	private List<Rating> ratings;
	
	public UserRating() {
		super();
	}

	public UserRating(int userId, String name, List<Rating> ratings) {
		super();
		this.userId = userId;
		this.name = name;
		this.ratings = ratings;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
