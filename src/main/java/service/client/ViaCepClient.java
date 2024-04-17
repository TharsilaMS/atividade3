package service.client;

import controller.response.ViaCep;
import org.springframework.web.client.RestTemplate;

public class ViaCepClient {

    private final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json";

    private final RestTemplate restTemplate;

    public ViaCepClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ViaCep getAddressByCEP(String cep) {
        String url = VIA_CEP_URL.replace("{cep}", cep);
        return restTemplate.getForObject(url, ViaCep.class);
    }
}


