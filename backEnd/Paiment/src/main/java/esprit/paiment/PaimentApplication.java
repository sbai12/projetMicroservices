package esprit.paiment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD

=======
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
@SpringBootApplication
public class PaimentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaimentApplication.class, args);
	}

}
