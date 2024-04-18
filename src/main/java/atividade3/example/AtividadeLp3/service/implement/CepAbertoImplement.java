package atividade3.example.AtividadeLp3.service.implement;

import atividade3.example.AtividadeLp3.controller.response.CepAberto;
import atividade3.example.AtividadeLp3.model.Endereco;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class CepAbertoImplement implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {
        String CEP_ABERTO_URL = "https://www.cepaberto.com/api/v3/cep?cep=" + cep+ "/json";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Token token=94053b879c9114bc25de8d8f59d82db7");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<CepAberto> response = restTemplate.exchange(CEP_ABERTO_URL, HttpMethod.GET, entity, CepAberto.class, cep);
        if (response.getStatusCode() == HttpStatus.OK) {
            CepAberto cepAbertoResponse = response.getBody();
            if (cepAbertoResponse != null) {
                return Endereco.builder()
                        .logradouro(cepAbertoResponse.getLogradouro())
                        .numero(null)
                        .estado(cepAbertoResponse.getEstado())
                        .cidade(cepAbertoResponse.getCidade())
                        .bairro(cepAbertoResponse.getBairro())
                        .cep(cep)
                        .build();
            }
        }
        return null;
    }
}
