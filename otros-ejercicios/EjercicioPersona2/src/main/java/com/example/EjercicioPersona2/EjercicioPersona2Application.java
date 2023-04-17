package com.example.EjercicioPersona2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjercicioPersona2Application {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPersona2Application.class, args);
	}

	@Bean
	public PersonaService service(){
		return  new PersonaService();
	}
}
