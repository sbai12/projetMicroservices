package esprit.commandegestion.FeignClient;


import esprit.commandegestion.DTO.LivraisonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "livraison") // même nom que celui défini dans spring.application.name de livraison
public interface LivraisonClient {

    @PostMapping("/livraison")
    LivraisonDTO creerLivraison(@RequestBody LivraisonDTO livraisonDto);

    @GetMapping("/livraison/order/{orderId}")
    LivraisonDTO getLivraisonByOrderId(@PathVariable("orderId") Long orderId);

    @GetMapping("/livraison")
    List<LivraisonDTO> getAllLivraisons();
}
