package com.donjondragon.microdonjondragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/* Cette classe, générée automatiquement par Spring Boot, est le point de démarrage de l'application, elle lance:
=> la classe SpringApplication, responsable du démarrage de l'application Spring.
	Cette classe va créer le fameux ApplicationContext dans lequel iront toutes les configurations
	générées automatiquement ou ajoutées.
 */

/*
@SpringBootApplication, qui est une simple encapsulation de trois annotations :

@Configuration : donne à la classe actuelle la possibilité de définir des configurations qui iront remplacer les
				traditionnels fichiers XML. Ces configurations se font via des Beans.

@EnableAutoConfiguration : permet, au démarrage de Spring, de générer automatiquement les configurations nécessaires
							en fonction des dépendances situées dans notre classpath.

@ComponentScan : Indique qu'il faut scanner les classes de ce package afin de trouver des Beans de configuration.
 */

@SpringBootApplication
// Pour générer la documentation
@EnableSwagger2
@RestController
public class DonjonDragonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonjonDragonApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Jojo Lapin Lapin") String name) {
		return String.format("Hello %s!", name);
	}

}
