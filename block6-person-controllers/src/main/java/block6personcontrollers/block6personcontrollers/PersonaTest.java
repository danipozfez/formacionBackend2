package block6personcontrollers.block6personcontrollers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonaTest {

	public static void main(String[] args) {
		SpringApplication.run(PersonaTest.class, args);
	}

	@Bean(name= "bean1")
	public Persona persona1() {
		return new Persona("daniel", "Jaén", 38);
	}
	@Bean(name= "bean2")
	public Persona persona2() {
		return new Persona("Manuel", "Granada", 18);
	}
	@Bean(name= "bean3")
	public Persona persona3() {
		return new Persona("Juan", "Córdoba", 25);
	}
}
