package net.buscacio.dayscode.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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
				     
	    mockMvc.perform(
	    		 get("/friends"))	    		 
	    		 .andExpect(status().isOk());
 	                
		
	}

}
