package atividade3.example.AtividadeLp3.service.implement;

import atividade3.example.AtividadeLp3.controller.response.BrasilApi;
import atividade3.example.AtividadeLp3.model.Endereco;
import org.springframework.web.client.RestTemplate;

public class BrasilApiImplement implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {
        String BRASIL_API_URL = "https://brasilapi.com.br/api/cep/v1/" + cep ;
        RestTemplate restTemplate = new RestTemplate();
        BrasilApi brasilApiResponse = restTemplate.getForObject(BRASIL_API_URL, BrasilApi.class, cep);
        if (brasilApiResponse != null) {
            return Endereco.builder()
                    .logradouro(brasilApiResponse.getLogradouro())
                    .numero(null)
                    .estado(brasilApiResponse.getUf())
                    .cidade(brasilApiResponse.getLocalidade())
                    .bairro(brasilApiResponse.getBairro())
                    .cep(cep)
                    .build();
        }
        return null;
    }
}
