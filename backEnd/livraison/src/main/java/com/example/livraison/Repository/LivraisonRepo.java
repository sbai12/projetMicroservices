package com.example.livraison.Repository;

import com.example.livraison.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Assurez-vous que le repository est bien annoté avec @Repository
public interface LivraisonRepo extends JpaRepository<Livraison, Long> {
}
