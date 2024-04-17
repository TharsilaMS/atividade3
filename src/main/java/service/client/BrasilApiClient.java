package service.client;

import controller.response.BrasilApi;
import org.springframework.web.client.RestTemplate;


public class BrasilApiClient {
    private final String BRASIL_API_URL = "https://brasilapi.com.br/api/cep/v1/{cep}";

    private final RestTemplate restTemplate;

    public BrasilApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BrasilApi getAddressByCEP(String cep) {
        String url = BRASIL_API_URL.replace("{cep}", cep);
        return restTemplate.getForObject(url, BrasilApi.class);
    }
}
