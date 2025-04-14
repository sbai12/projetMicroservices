package esprit.paiment.services;

import esprit.paiment.model.paiment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;


import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class PayPallService {

    @Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    @Value("${paypal.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String createPayPalPayment(paiment p) {
        // 1. Authentifier pour obtenir access_token
        String credentials = clientId + ":" + clientSecret;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + encodedCredentials);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(form, headers);


        // Effectuer la requête pour obtenir le token
        ResponseEntity<Map> tokenResponse = restTemplate.exchange(
                baseUrl + "/v1/oauth2/token",
                HttpMethod.POST,
                tokenRequest,
                Map.class
        );

        String accessToken = (String) tokenResponse.getBody().get("access_token");

        // 2. Créer le paiement avec l'Access Token
        headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);  // Authentification avec l'Access Token
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> paymentRequest = Map.of(
                "intent", "sale",
                "redirect_urls", Map.of(
<<<<<<< HEAD
                        "return_url", "http://localhost:4200/payment-success",
                        "cancel_url", "http://localhost:4200/payment-cancel"
=======
                        "return_url", "http://localhost:8086/paiement/execute",
                        "cancel_url", "http://localhost:8086/paiement/cancel"
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
                ),
                "payer", Map.of("payment_method", "paypal"),
                "transactions", List.of(
                        Map.of("amount", Map.of(
                                "total", p.getAmount().toString(),
                                "currency", "USD"
                        ))
                )
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(paymentRequest, headers);

        // Effectuer la requête pour créer le paiement
        ResponseEntity<Map> response = restTemplate.exchange(
                baseUrl + "/v1/payments/payment",
                HttpMethod.POST,
                request,
                Map.class
        );

<<<<<<< HEAD
=======
        // 3. Extraire l'URL de redirection de PayPal
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
        List<Map<String, String>> links = (List<Map<String, String>>) response.getBody().get("links");
        return links.stream()
                .filter(link -> "approval_url".equals(link.get("rel")))
                .findFirst()
                .map(link -> link.get("href"))
                .orElseThrow(() -> new RuntimeException("No PayPal approval_url found"));
    }
<<<<<<< HEAD

=======
>>>>>>> ac0fd6d813d7f485f335f18847b9e07b523de451
}
