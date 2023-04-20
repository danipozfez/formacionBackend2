package block6pathvariableheaders;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controlador {

    @PostMapping("/saludo")
    public Saludo saludo(@RequestBody Saludo saludo){
        return saludo;
    }
    @GetMapping("/saludo/{id}")
    public String saludo(@PathVariable int id){
        return "id: "+id;
    }
    @PutMapping("/putParam")
    public Map<Integer,Integer> mapear(@RequestParam int id1,@RequestParam int id2){
        Map<Integer,Integer> resultMap= new HashMap<>();
        resultMap.put(1,id1);
        resultMap.put(2,id2);
        return resultMap;
    }
}
