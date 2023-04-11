package block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner{

	@Autowired
	private  PrimeraClase primeraClase;
	@Autowired
	private SegundaClase segundaClase;


	public static void main(String[] args) {

		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		primeraClase.saludar();
		segundaClase.saludar();
		TerceraClase.saludar();
	}
}



