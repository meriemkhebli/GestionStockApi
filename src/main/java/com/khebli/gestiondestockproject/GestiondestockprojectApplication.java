package com.khebli.gestiondestockproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//j'ai ajouté @EnableWebMvc apres le déploiement de swagger 2,  un probelem est generé documentationAPi nullpointerexception
@SpringBootApplication
@EnableJpaAuditing
public class GestiondestockprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestiondestockprojectApplication.class, args);
	}

}
