package com.example.livraison.Repository;

import com.example.livraison.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepo extends JpaRepository<Livraison,Long> {
}
