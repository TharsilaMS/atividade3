package service;

import model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import repositotory.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(String cep) {
        // Lógica para determinar qual API utilizar baseada nas configurações
        String apiUrl = determinarApiUrl(cep);

        // Fazer requisição à API
        RestTemplate restTemplate = new RestTemplate();
        Endereco endereco = restTemplate.getForObject(apiUrl, Endereco.class);

        // Salvar no banco de dados local
        enderecoRepository.save(endereco);

        return endereco;
    }

    private String determinarApiUrl(String cep) {
        // Lógica para determinar qual API utilizar baseada nas configurações
        // Implemente aqui a lógica de acordo com as configurações fornecidas
        return "URL_DA_API"; // Substitua "URL_DA_API" pela URL correta da API
    }
}
