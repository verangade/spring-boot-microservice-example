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

import com.raveesoft.moviecatalogservice.models.CatalogItem;
import com.raveesoft.moviecatalogservice.models.Movie;
import com.raveesoft.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{catalogId}")
	public List<CatalogItem> getCatalog(@PathVariable String catalogId){
		
		Movie movie = restTemplate.getForObject("http://localhost:8082/movies/1", Movie.class);
		
		List<Rating> ratings = Arrays.asList(
				new Rating("123", 4),
				new Rating("234", 5)
				
		);
		
		return ratings.stream().map(rating -> {
			restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName()	, movie.getDesc(),rating.getRating());
			
		
		}).collect(Collectors.toList());
		
		/*return Collections.singletonList(
				new CatalogItem("Avatar", "Avatar 2009", 5)
				);*/
		
	}
}
