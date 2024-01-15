package net.buscacio.dayscode.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Movie(
		@JsonAlias("Title")
		String titulo,
		@JsonAlias("Poster")
		String poster,
		@JsonAlias("imdbRating")
		String nota, 
		@JsonAlias("Year")
		String ano ) {
	


}
