package com.example.livraison.service;

import com.example.livraison.Repository.LivraisonRepo;
import com.example.livraison.entity.Livraison;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class livraisonserv implements ILivraisonServ {

    private final LivraisonRepo livraisonRepo;

    // Constructeur explicite avec @Autowired
    @Autowired
    public livraisonserv(LivraisonRepo livraisonRepo) {
        this.livraisonRepo = livraisonRepo;
    }

    @Override
    public Livraison createLivraison(Livraison liv) {
        return livraisonRepo.save(liv);
    }

    @Override
    public List<Livraison> getAllLivraisons() {
        return livraisonRepo.findAll();
    }

    @Override
    public Optional<Livraison> getLivraisonyById(Long id) {
        return livraisonRepo.findById(id);
    }

    @Override
    public Livraison updateLivraison(Long id, Livraison liv) {
        liv.setId(id);
        return livraisonRepo.save(liv);
    }

    @Override
    public void deleteLivraison(Long id) {
        livraisonRepo.deleteById(id);
    }
}
