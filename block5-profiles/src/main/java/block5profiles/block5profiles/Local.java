package block5profiles.block5profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("Local")
public class Local {

    @Value("${spring.profiles.active}")
    String perfil;
    @Bean
    CommandLineRunner localRun(){
        return args -> {
            System.out.println("hola desde "+perfil);

        };
    }

}
