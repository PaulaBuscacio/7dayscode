package net.buscacio.dayscode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.buscacio.dayscode.dto.Movie;
import net.buscacio.dayscode.service.SearchClientWebReactiveService;

@RestController
public class APIController {
	
	@Autowired
	SearchClientWebReactiveService searchClient; 
	
	public APIController(SearchClientWebReactiveService searchClient) {
		this.searchClient = searchClient;
	}
	
	
	@GetMapping("/{movie}")
	public ResponseEntity<Movie> getAPI(@PathVariable String movie) {
		Movie response = searchClient.searchAPI(movie);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
		
		
	}

}
