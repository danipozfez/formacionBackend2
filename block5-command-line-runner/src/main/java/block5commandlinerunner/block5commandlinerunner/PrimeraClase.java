package block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PrimeraClase {

    @PostConstruct
    public void saludar(){
        System.out.println("hola desde la clase inicial");
    }
}
