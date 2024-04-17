package service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Endereco;
import org.springframework.stereotype.Service;
import service.implement.ExternalCepRestService;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoService {
    private final ExternalCepRestService externalCepRestService;

    public Endereco searchEndereco(String cep) {
        return externalCepRestService.searchByCep(cep);
    }

}
