package cl.duocuc.orderservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class UserClient {
    private final RestTemplate restTemplate;

    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public boolean userExists(String userId) {
        try{
            String url = "http://localhost:8080/users/"+userId;
            restTemplate.getForObject(url, String.class);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
