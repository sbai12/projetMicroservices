package esprit.paiment.FeignClient;



import esprit.paiment.DTO.OrderDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "commandeGestion") // nom = spring.application.name
public interface CommandeClient {
    @GetMapping("/orders/{id}")
    OrderDTO getOrderById(@PathVariable("id") Long id);
}

