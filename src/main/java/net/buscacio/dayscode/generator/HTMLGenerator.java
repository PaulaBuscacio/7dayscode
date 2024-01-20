package net.buscacio.dayscode.generator;

import java.io.PrintWriter;

import net.buscacio.dayscode.dto.Movie;

public class HTMLGenerator {	
	
	  private final PrintWriter writer;

	    public HTMLGenerator(PrintWriter writer) {
	        this.writer = writer;
	    }
	
	public void generate(Movie movie) {

		String docType = """
				<!DOCTYPE html>\r\n
				<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:th=\"http://www.thymeleaf.org\">
				""";
		 String head =
		            """
		            <head>
		                <meta charset=\"utf-8\">
		                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
		                <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\">					
		            </head>
		            """;

		    String divTemplate =
		            """
		            <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
		                <h4 class=\"card-header\">%s</h4>
		                <div class=\"card-body\">
		                    <img class=\"card-img\" src=\"%s\" alt=\"%s\">
		                    <p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
		                </div>
		            </div>
		            """;
		    
			
		writer.write(docType);
		writer.write(head);
		writer.write("<body>");	
		writer.write(String.format(divTemplate, movie.titulo(), movie.poster(), movie.titulo(), movie.nota(), movie.ano()));
		writer.write( """
                    </body>
                </html>
                """);

	}
	
	

}
