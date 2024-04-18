package atividade3.example.AtividadeLp3.service.implement;

import atividade3.example.AtividadeLp3.controller.response.ViaCep;
import atividade3.example.AtividadeLp3.model.Endereco;
import org.springframework.web.client.RestTemplate;

public class ViaCepImplement implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {
        String VIA_CEP_URL = "https://viacep.com.br/ws/" +cep+ "/json";
        RestTemplate restTemplate = new RestTemplate();
        ViaCep viaCepResponse = restTemplate.getForObject(VIA_CEP_URL, ViaCep.class, cep);
        if (viaCepResponse != null) {
            return Endereco.builder()
                    .logradouro(viaCepResponse.getLogradouro())
                    .estado(viaCepResponse.getUf())
                    .cidade(viaCepResponse.getLocalidade())
                    .bairro(viaCepResponse.getBairro())
                    .cep(cep)
                    .build();

        }
        return null;
    }
}
