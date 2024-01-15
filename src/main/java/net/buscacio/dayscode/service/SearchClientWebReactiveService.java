package net.buscacio.dayscode.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import net.buscacio.dayscode.dto.Movie;

@Service 
public class SearchClientWebReactiveService {

	
	String BASE_URL = System.getenv("BASE_URL");
    String API_KEY = System.getenv("API_Key");

    public Movie searchAPI(String movie) {
      
        WebClient client = WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        Movie response = client
                .get()
                .uri("/?t=" + movie + "&apikey=" + API_KEY)
                .retrieve()
                .bodyToMono(Movie.class)                 
                .block();
                
     
        return response;
    }
}
