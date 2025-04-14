package tn.esprit.user.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.user.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email); // Méthode pour trouver un utilisateur par email

}
