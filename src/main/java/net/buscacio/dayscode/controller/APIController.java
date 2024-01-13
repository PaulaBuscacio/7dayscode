package net.buscacio.dayscode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.buscacio.dayscode.service.SearchClientWebReactiveService;

@RestController
public class APIController {
	
	@Autowired
	SearchClientWebReactiveService searchClient; 
	
	
	@GetMapping("/{serie}")
	public String getAPI(@PathVariable String serie) {
		return searchClient.searchAPI(serie);
		
		
		
	}

}
