package cl.duocuc.orderservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Component
public class ProductClient {
    private final RestTemplate restTemplate;

    public ProductClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean allProductsExist(List<String> productIds) {
        try {
            for (String id : productIds) {
                String url = "http://localhost:8081/products/" + id;
                restTemplate.getForObject(url, Map.class);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public double calculateTotal(List<String> productIds) {
        double total = 0;
        for (String id : productIds) {
            try {
                String url = "http://localhost:8081/products/" + id;
                Map product = restTemplate.getForObject(url, Map.class);
                total += Double.parseDouble(product.get("precio").toString());
            } catch (Exception e) {
                // podrías registrar error o continuar
            }
        }
        return total;
    }
}
