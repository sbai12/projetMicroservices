package com.example.livraison.controller;

import com.example.livraison.entity.Livraison;
import com.example.livraison.service.livraisonserv;
import lombok.RequiredArgsConstructor; // Utilisation de @RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 // Lombok crée un constructeur pour les dépendances 'final'
@RestController
@RequestMapping("/Livraison")
public class LivraisonController {

    private final livraisonserv service;  // Dépendance injectée par le constructeur
    @Autowired
    public LivraisonController(livraisonserv service) {
        this.service = service;
    }
     @PostMapping
     public ResponseEntity<Livraison> createLivraison(@RequestBody Livraison livraison) {
         try {
             Livraison createdLivraison = service.createLivraison(livraison);
             return ResponseEntity.status(HttpStatus.CREATED).body(createdLivraison);
         } catch (Exception e) {
             System.out.println("Error creating Livraison: " + e.getMessage());
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         }
     }



     // Méthode pour récupérer toutes les livraisons
    @GetMapping
    public List<Livraison> getAll() {
        return service.getAllLivraisons();
    }

    // Méthode pour récupérer une livraison par ID
    @GetMapping("/{id}")
    public ResponseEntity<Livraison> getById(@PathVariable Long id) {
        return service.getLivraisonyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Méthode pour mettre à jour une livraison
    @PutMapping("/{id}")
    public Livraison update(@PathVariable Long id, @RequestBody Livraison liv) {
        return service.updateLivraison(id, liv);
    }

    // Méthode pour supprimer une livraison
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteLivraison(id);
        return ResponseEntity.noContent().build();
    }
}
