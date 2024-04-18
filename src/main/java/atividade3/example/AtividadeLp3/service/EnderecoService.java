package atividade3.example.AtividadeLp3.service;


import atividade3.example.AtividadeLp3.service.implement.ExternalCepRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import atividade3.example.AtividadeLp3.model.Endereco;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoService {
    private final ExternalCepRestService externalCepRestService;

    public Endereco searchEndereco(String cep) {
        return externalCepRestService.searchByCep(cep);
    }

}
