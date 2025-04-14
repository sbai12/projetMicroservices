package esprit.paiment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PaimentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaimentApplication.class, args);
	}

}
