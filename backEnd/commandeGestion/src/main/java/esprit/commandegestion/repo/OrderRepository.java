package esprit.commandegestion.repo;

import esprit.commandegestion.entity.Orderr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orderr, Long> {
}
