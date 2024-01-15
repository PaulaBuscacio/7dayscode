package net.buscacio.dayscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.buscacio.dayscode.service.SearchClientRestTemplateService;
import net.buscacio.dayscode.service.SearchClientWebReactiveService;

@SpringBootApplication
public class Application{ 

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
