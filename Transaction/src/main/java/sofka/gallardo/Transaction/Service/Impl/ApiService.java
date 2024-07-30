package sofka.gallardo.Transaction.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getDataFromApi(String name) {
        String url = "http://localhost:8081/api/v1/client/search-name/"+name; // URL de la API externa
        return restTemplate.getForObject(url, String.class);
    }
}