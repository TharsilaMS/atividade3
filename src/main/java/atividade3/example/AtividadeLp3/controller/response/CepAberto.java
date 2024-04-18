package atividade3.example.AtividadeLp3.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CepAberto {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +

                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
