package service.implement;

import controller.response.ViaCep;
import model.Endereco;
import org.springframework.web.client.RestTemplate;

public class ViaCepImplement implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {
        return Endereco.builder()
                .logradouro("Via cep")
                .cep(cep)
                .build();
    }
}


