package net.buscacio.dayscode.controller;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletResponse;
import net.buscacio.dayscode.dto.Movie;
import net.buscacio.dayscode.generator.HTMLGenerator;
import net.buscacio.dayscode.service.SearchClientWebReactiveService;

@Controller
public class APIController {
	
	@Autowired
	SearchClientWebReactiveService searchClient; 

	
	public APIController(SearchClientWebReactiveService searchClient) {
		this.searchClient = searchClient;
	}
	
	
//	@GetMapping("/{movie}")
//	public ResponseEntity<Movie> getAPI(@PathVariable String movie) throws FileNotFoundException {
//		Movie response = searchClient.searchAPI(movie);
//		PrintWriter writer = new PrintWriter("src/main/resources/content.html");
//        new HTMLGenerator(writer).generate(response);
//		
//		return new ResponseEntity<>(response, HttpStatus.OK);
//		
//		
//		
//	}

	@GetMapping("/{movie}")
	public String getAPI(@PathVariable("movie") String movie, Model model, HttpServletResponse servletResponse) throws FileNotFoundException {
		
		Movie response = searchClient.searchAPI(movie);
		model.addAttribute(movie, response);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("src/main/resources/templates/index.html", false));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
        new HTMLGenerator(writer).generate(response);
        writer.close();
        
        servletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        servletResponse.setHeader("Pragma", "no-cache");
        servletResponse.setHeader("Expires", "0");

		return "index";
		
		
		
	}
	
	  @GetMapping("/mostrarpagina")
	    public String mostrarPagina() {
	        return "minhapagina";
	    }

}
