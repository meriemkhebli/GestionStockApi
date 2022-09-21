package com.khebli.gestiondestockproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//j'ai ajouté @EnableWebMvc apres le déploiement de swagger 2,  un probelem est generé documentationAPi nullpointerexception
@SpringBootApplication
@EnableSwagger2

public class GestiondestockprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestiondestockprojectApplication.class, args);
	}


}
