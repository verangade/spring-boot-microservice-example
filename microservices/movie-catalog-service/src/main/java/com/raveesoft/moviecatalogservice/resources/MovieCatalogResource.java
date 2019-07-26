package com.raveesoft.moviecatalogservice.resources;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raveesoft.moviecatalogservice.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@RequestMapping("/{catalogId}")
	public List<CatalogItem> getCatalog(@PathVariable String catalogId){
		return Collections.singletonList(
				new CatalogItem("Avatar", "Avatar 2009", 5)
				);
		
	}
}
