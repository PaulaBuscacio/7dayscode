package net.buscacio.dayscode.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import net.buscacio.dayscode.service.SearchClientWebReactiveService;

@WebFluxTest(APIController.class)
public class ControllerTest {
	

	@Autowired
    private WebTestClient webTestClient;
	
	@MockBean
    SearchClientWebReactiveService service;
    
	
	@Test
	public void shouldReturnApiCallHappyPath() throws Exception {
				     
	    webTestClient
	    		 .get().uri("/friends")	    		 
	    		 .accept(MediaType.APPLICATION_JSON)
	                .exchange()
	                .expectStatus().isOk()
	                .expectBody(String.class);
 	                
		
	}

}
