package esprit.commandegestion.restController;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import esprit.commandegestion.entity.Orderr;
import esprit.commandegestion.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451

@RestController
@RequestMapping("/Command")
public class CommandRestController {
<<<<<<< HEAD
    private String title="Hello, i'm the  Command Micro-Service";
    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }
}
=======

    @Autowired
    OrderService orderService;

    // Création d'une commande
    @PostMapping
    public Orderr createOrder(@RequestBody Orderr orderr) {
        return orderService.createOrder(orderr);
    }

    // Récupérer une commande par son ID
    @GetMapping("/{id}")
    public Optional<Orderr> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Récupérer toutes les commandes
    @GetMapping
    public List<Orderr> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Mettre à jour une commande
    @PutMapping("/{id}")
    public Orderr updateOrder(@PathVariable Long id, @RequestBody Orderr orderr) {
        return orderService.updateOrder(id, orderr);
    }

    // Supprimer une commande
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
