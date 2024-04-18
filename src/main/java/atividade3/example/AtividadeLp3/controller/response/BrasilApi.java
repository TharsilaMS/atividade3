package atividade3.example.AtividadeLp3.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrasilApi {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

}