package block6personcontrollers.block6personcontrollers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonaTest {

	public static void main(String[] args) {
		SpringApplication.run(PersonaTest.class, args);
	}

	@Bean
	public PersonaService service(){
		return  new PersonaService();
	}
}
