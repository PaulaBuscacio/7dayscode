package net.buscacio.dayscode.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import net.buscacio.dayscode.dto.Movie;
import net.buscacio.dayscode.service.SearchClientWebReactiveService;

@WebMvcTest(APIController.class)
public class ControllerMockTest {
	

    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    SearchClientWebReactiveService service;
    
    @InjectMocks
    APIController client;
    
	
	@Test
	public void shouldReturnApiCallHappyPath() throws Exception {
		
		Movie m = new Movie("movieTest", "imageUrl", "9.0", "2024");
		
		when(service.searchAPI("test")).thenReturn(m);
				     
	  MvcResult result =  mockMvc.perform(
	    		 get("/test"))	    		 
	    		 .andExpect(status().isOk())
	    		 .andReturn();
	    assertNotNull(result);
 	                
		
	}

}
