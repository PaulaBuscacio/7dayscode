package net.buscacio.dayscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.buscacio.dayscode.generator.HTMLGenerator;

@SpringBootApplication
public class Application{ 

	public static void main(String[] args) {
//		HTMLGenerator hg = new HTMLGenerator();
//		hg.generate();
		SpringApplication.run(Application.class, args);

	}

}
