package block6personcontrollers.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador3 {
    @Autowired
    @Qualifier("bean1")
    private Persona persona1;
    @Autowired
    @Qualifier("bean2")
    private Persona persona2;
    @Autowired
    @Qualifier("bean3")
    private Persona persona3;

    @GetMapping("/controlador/bean/{bean}")
    public Persona gePersona(@PathVariable String bean){
        switch (bean){
            case "bean1":
                return persona1;
            case "bean2":
                return persona2;
            case "bean3":
                return persona3;
            default:
                return null;
        }
    }
}
