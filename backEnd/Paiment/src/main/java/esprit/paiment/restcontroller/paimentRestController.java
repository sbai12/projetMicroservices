package esprit.paiment.restcontroller;

import esprit.paiment.model.paiment;
import esprit.paiment.repository.PaymentRepository;
import esprit.paiment.services.PayPallService;
import esprit.paiment.services.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200") // Autorise l'origine de ton frontend
@RequestMapping("/paiement")
public class paimentRestController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PayPallService payPallService;



    @PostMapping("/create")
    public paiment createPayment(@RequestBody paiment p) {
        // Créer un paiement PayPal et obtenir l'URL de redirection
        String approvalUrl = payPallService.createPayPalPayment(p);

        // Mettre à jour l'URL d'approbation dans l'objet paiment
        p.setApprovalUrl(approvalUrl);

        // Enregistrer l'objet paiment avec le statut "PENDING"
        p.setStatus("PENDING");

        paymentService.createPayment(p);

        return p;
    }


    @PutMapping("/validate/{id}")
    public paiment validatePayment(@PathVariable Long id) {
        return paymentService.validatePayment(id);
    }
    @GetMapping("/execute")
    public String executePayment(@RequestParam String paymentId, @RequestParam String payerId) {
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
