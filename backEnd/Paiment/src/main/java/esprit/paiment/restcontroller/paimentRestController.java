package esprit.paiment.restcontroller;

import esprit.paiment.model.paiment;
import esprit.paiment.repository.PaymentRepository;
import esprit.paiment.services.PayPallService;
import esprit.paiment.services.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
@RestController
@CrossOrigin(origins = "http://localhost:4200") // Autorise l'origine de ton frontend
=======

@RestController
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
@RequestMapping("/paiement")
public class paimentRestController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PayPallService payPallService;


<<<<<<< HEAD

=======
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
    @PostMapping("/create")
    public paiment createPayment(@RequestBody paiment p) {
        // Créer un paiement PayPal et obtenir l'URL de redirection
        String approvalUrl = payPallService.createPayPalPayment(p);

        // Mettre à jour l'URL d'approbation dans l'objet paiment
        p.setApprovalUrl(approvalUrl);

        // Enregistrer l'objet paiment avec le statut "PENDING"
        p.setStatus("PENDING");

<<<<<<< HEAD
        paymentService.createPayment(p);

        return p;
=======
        // Sauvegarder le paiement dans la base de données
        paymentService.createPayment(p);

        return p;  // Retourner l'objet paiment avec l'URL de redirection
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
    }


    @PutMapping("/validate/{id}")
    public paiment validatePayment(@PathVariable Long id) {
        return paymentService.validatePayment(id);
    }
    @GetMapping("/execute")
    public String executePayment(@RequestParam String paymentId, @RequestParam String payerId) {
<<<<<<< HEAD
=======
        // Utiliser les informations de paymentId et payerId pour exécuter le paiement final sur PayPal
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
        return "Paiement exécuté avec paymentId: " + paymentId + " et payerId: " + payerId;
    }
    @GetMapping("/cancel")
    public String cancelPayment() {
        return "Paiement annulé.";
    }











    // Lister tous les paiements
    @GetMapping("/all")
    public List<paiment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
