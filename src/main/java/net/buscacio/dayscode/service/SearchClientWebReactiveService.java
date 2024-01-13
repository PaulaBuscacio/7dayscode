package net.buscacio.dayscode.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service 
public class SearchClientWebReactiveService {

	
	String BASE_URL = System.getenv("BASE_URL");
    String API_KEY = System.getenv("API_Key");

    public String searchAPI(String serie) {
      
        WebClient client = WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        String response = client
                .get()
                .uri("/?type=series&t=" + serie + "&apikey=" + API_KEY)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(response);
        return response;
    }
}
