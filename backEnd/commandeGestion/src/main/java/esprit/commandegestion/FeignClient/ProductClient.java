package esprit.commandegestion.FeignClient;


import esprit.commandegestion.DTO.ProductDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "productGestion") // nom du microservice dans Eureka
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    ProductDto getProductById(@PathVariable("id") int id);

    @GetMapping("/api/products")
    List<ProductDto> getAllProducts();
}
