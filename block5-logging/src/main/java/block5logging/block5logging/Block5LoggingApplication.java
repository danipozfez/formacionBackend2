package block5logging.block5logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5LoggingApplication implements CommandLineRunner {

	@Autowired
	Controller controller;
	public static void main(String[] args) {
		SpringApplication.run(Block5LoggingApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		controller.index();
	}
}
