package controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CepAberto {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;

}

