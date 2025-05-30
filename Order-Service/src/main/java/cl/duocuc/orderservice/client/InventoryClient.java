package cl.duocuc.orderservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryClient {
    private final RestTemplate restTemplate;

    public InventoryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public void adjustStock(String productId, int delta) {
        String url = "http://localhost:8083/inventory/product/"+productId;
        restTemplate.put(url, null);
        String adjustUrl = "http://localhost:8083/inventory/"+productId+"/adjust?delta="+(-delta);
        restTemplate.patchForObject(adjustUrl, null, Void.class);
    }
}
