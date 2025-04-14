package esprit.paiment.services;


<<<<<<< HEAD
=======
import esprit.paiment.DTO.OrderDTO;
import esprit.paiment.DTO.UserDTO;
import esprit.paiment.FeignClient.CommandeClient;
import esprit.paiment.FeignClient.UserClient;
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
import esprit.paiment.model.paiment;
import esprit.paiment.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
<<<<<<< HEAD

    @Transactional
=======
    CommandeClient commandeClient;
    UserClient userClient;

    public void afficherInfoUtilisateur(Long userId) {
        UserDTO user = userClient.getUserById(userId);
        System.out.println("Utilisateur : " + user.getFirstName() + " " + user.getLastName());
    }
    public PaymentService(CommandeClient commandeClient) {
        this.commandeClient = commandeClient;
    }

    public void verifierCommandeAvantPaiement(Long orderId) {
        OrderDTO commande = commandeClient.getOrderById(orderId);
        System.out.println("Commande : " + commande.getDeliveryAddress() + " | Statut : " + commande.getStatus());
    }
    @Transactional

>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
    public paiment createPayment(paiment p) {
        p.setStatus("PENDING");
        return paymentRepository.save(p);

    }
    @Transactional
    public paiment validatePayment(Long id) {
        paiment p = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé avec l'ID: " + id));

        p.setStatus("SUCCESS");
        return paymentRepository.save(p);
    }



}
