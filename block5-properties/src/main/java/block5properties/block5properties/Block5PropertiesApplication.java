package block5properties.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5PropertiesApplication implements CommandLineRunner {

	@Value("${greeting}")
	private String saludo;
	@Value("${my.number}")
	private String numero;
	private String nuevaPropiedadEnSO = System.getenv().get("new.property");


	public static void main(String[] args) {
		SpringApplication.run(Block5PropertiesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("hola "+saludo);
		System.out.println("numero "+numero);
		System.out.println("nueva propiedad "+nuevaPropiedadEnSO);

	}


}
