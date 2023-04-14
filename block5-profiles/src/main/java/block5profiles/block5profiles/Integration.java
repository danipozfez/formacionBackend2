package block5profiles.block5profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Configuration
@Profile("Integration")

public class Integration {

    @Value("${spring.profiles.active}")
    String perfil;
    @Bean
    CommandLineRunner integrationRun(){
        return args -> {
            System.out.println("hola desde "+perfil);

        };
    }

}
