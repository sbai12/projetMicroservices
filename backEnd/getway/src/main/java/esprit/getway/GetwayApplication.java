package esprit.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayApplication.class, args);
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("user-service",
                        r -> r.path("/UserGestion/**")
                                .uri("lb://UserGestion"))
                .route("commande-service",
                        r -> r.path("/commandeGestion/**")
                                .uri("lb://commandeGestion"))
                .route("produit-service",
                        r -> r.path("/ProductGestion/**")
                                .uri("lb://ProductGestion"))
                .route("paiement-service",
                        r -> r.path("/Paiment/**")
                                .uri("lb://Paiment"))
                .route("livraison-service",
                        r -> r.path("/Livraison/**")
                                .uri("lb://Livraison"))
                .build();

    }
}
