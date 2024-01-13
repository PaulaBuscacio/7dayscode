package net.buscacio.dayscode.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchClientRestTemplateService {
	
	String API_KEY = System.getenv("API_Key");

    @Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

    public void searchApi() {

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "https://www.omdbapi.com/?type=series&t=friends&apikey=" + API_KEY;
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl, String.class);
        System.out.println(response);

    }
}
