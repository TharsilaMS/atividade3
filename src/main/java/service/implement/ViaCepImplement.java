package service.implement;

import controller.response.ViaCep;
import model.Endereco;
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
                    .numero(null)
                    .estado(viaCepResponse.getUf())
                    .cidade(viaCepResponse.getLocalidade())
                    .bairro(viaCepResponse.getBairro())
                    .cep(cep)
                    .build();
        }
        return null;
    }
}
