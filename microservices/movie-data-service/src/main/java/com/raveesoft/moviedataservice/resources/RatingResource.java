package com.raveesoft.moviedataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raveesoft.moviedataservice.models.Rating;
import com.raveesoft.moviedataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable int movieId) {
		return new Rating("1", 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId){
		List<Rating> ratings = Arrays.asList(
				new Rating("123",3),
				new Rating("234",4)
				
				);
		
		UserRating rating = new UserRating();
		rating.setRating(ratings);
		return rating;
	}

}
