package block7crudvalidation.block7crudvalidation.controller;

import block7crudvalidation.block7crudvalidation.controller.dto.ProfesorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", name = "myFeign")
public interface MyFeign {
    @GetMapping("profesor/{id}")
    public ProfesorOutputDto getProfesor(@PathVariable int id);

}
