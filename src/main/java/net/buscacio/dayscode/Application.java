package net.buscacio.dayscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.buscacio.dayscode.service.SearchClientRestTemplateService;
import net.buscacio.dayscode.service.SearchClientWebReactiveService;

@SpringBootApplication
public class Application implements Runnable{



	@Override
	public void run() {
		SearchClientRestTemplateService searchClient = new SearchClientRestTemplateService();
		SearchClientWebReactiveService searchClientWebReactive = new SearchClientWebReactiveService();
		searchClient.searchApi();
		searchClientWebReactive.searchAPI("friends");
	}
	public static void main(String[] args) {
		Application app = new Application();
		SpringApplication.run(Application.class, args);
		app.run();


	}

}
