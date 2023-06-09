package block11uploaddownloadfiles.block11uploaddownloadfiles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Block11UploadDownloadFilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block11UploadDownloadFilesApplication.class, args);
	}
	@Bean
	CommandLineRunner init (StorageService storageService){
		return (args)->{
			storageService.deleteAll();
			storageService.init();
		};
	}
}
