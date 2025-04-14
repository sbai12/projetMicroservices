package esprit.usergestion;

<<<<<<< HEAD
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
=======
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
		import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
		import org.springframework.web.bind.annotation.GetMapping;
		import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
public class UserGestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserGestionApplication.class, args);
	}

<<<<<<< HEAD
}
=======
	@GetMapping("/user/test")
	public String testEndpoint() {
		System.out.println("UserGestion Service: Test endpoint accessed");
		return "UserGestion Service is running!";
	}
}
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
