package esprit.commandegestion.service;

import esprit.commandegestion.entity.Orderr;
import esprit.commandegestion.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    // Création d'une commande
    public Orderr createOrder(Orderr orderr) {
        return orderRepository.save(orderr);
    }

    // Récupérer une commande par son ID
    public Optional<Orderr> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Récupérer toutes les commandes
    public List<Orderr> getAllOrders() {
        return orderRepository.findAll();
    }

    // Mettre à jour une commande existante
    public Orderr updateOrder(Long id, Orderr orderrDetails) {
        Orderr orderr = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderr.setDeliveryAddress(orderrDetails.getDeliveryAddress());
        orderr.setStatus(orderrDetails.getStatus());
        return orderRepository.save(orderr);
    }

    // Supprimer une commande
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
