package esprit.paiment.services;


import esprit.paiment.model.paiment;
import esprit.paiment.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
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
