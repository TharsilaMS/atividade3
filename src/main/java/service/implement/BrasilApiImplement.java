package service.implement;

import controller.response.BrasilApi;
import model.Endereco;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class BrasilApiImplement implements ExternalCepRestService {
    private final RestTemplate restTemplate;

    public BrasilApiImplement(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Endereco searchByCep(String cep) {

        String BRASIL_API_URL = "https://brasilapi.com.br/api/cep/v1/{cep}";

        Map<String, String> params = new HashMap<>();
        params.put("cep", cep);

        BrasilApi response = restTemplate.getForObject(BRASIL_API_URL, BrasilApi.class, params);
        Endereco endereco = new Endereco();
        endereco.setLogradouro(response.getLogradouro());
        endereco.setCep(response.getCep());


        return endereco;
    }
}

    }
