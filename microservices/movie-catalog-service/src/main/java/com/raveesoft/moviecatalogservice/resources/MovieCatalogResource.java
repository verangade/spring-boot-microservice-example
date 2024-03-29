package com.raveesoft.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.raveesoft.moviecatalogservice.models.CatalogItem;
import com.raveesoft.moviecatalogservice.models.Movie;
import com.raveesoft.moviecatalogservice.models.Rating;
import com.raveesoft.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod="fallBackMethod")
	public List<CatalogItem> getCatalog(@PathVariable String userId){
		
		//UserRating ratings = restTemplate.getForObject("http://movie-rating-service/ratingsdata/users/"+userId, UserRating.class);
		//Movie movie = restTemplate.getForObject("http://movie-info-service/movies/1", Movie.class);
		
		/*List<Rating> ratings = Arrays.asList(
				new Rating("123", 4),
				new Rating("234", 5)
				
		);*/
		
		/*return ratings.getRating().stream().map(rating -> {
			restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName()	, movie.getDesc(),rating.getRating());
			
		
		}).collect(Collectors.toList());*/
		
		return Arrays.asList(new CatalogItem("Heloooooo"	, "",0));
		
	}
	
	public List<CatalogItem> fallBackMethod(@PathVariable String userId){
		return Arrays.asList(new CatalogItem("No Movie"	, "",0));
		
	}


}
