package fr.eni.Filmotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FilmothequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmothequeApplication.class, args);
	}
		
	// Paramétrage du context path de l'application (nom de l'application dans l'URL).
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		return factory -> factory.setContextPath("/filmotheque");
	}

}
