package block6personcontrollers.block6personcontrollers;

import org.springframework.stereotype.Service;

@Service
public class CiudadService {
    public Ciudad crearCiudad(String nombre, int numeroHabitantes){
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(nombre);
        ciudad.setNumeroHabitantes(numeroHabitantes);
        return ciudad;
    }
}
