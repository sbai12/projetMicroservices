package esprit.paiment.repository;
import esprit.paiment.model.paiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends JpaRepository<paiment, Long> {
}
