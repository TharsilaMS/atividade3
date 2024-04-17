package model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Endereco {
    private String logradouro;
    private Integer numero;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
}
