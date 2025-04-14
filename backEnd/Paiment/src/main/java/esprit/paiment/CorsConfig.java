package esprit.paiment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applique CORS à toutes les URL
                .allowedOrigins("http://localhost:4200") // Autorise l'origine de ton frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Autorise les méthodes HTTP spécifiques
                .allowedHeaders("*") // Autorise tous les headers
                .allowCredentials(true); // Autorise les cookies/credentials si nécessaires
    }
}
