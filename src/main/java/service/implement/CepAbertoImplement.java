package service.implement;
import controller.response.CepAberto;
import model.Endereco;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class CepAbertoImplement implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {
        return Endereco.builder()
                .logradouro("Cep Aberto")
                .cep(cep)
                .build();
    }
}



