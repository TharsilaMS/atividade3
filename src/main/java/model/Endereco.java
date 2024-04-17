package model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Endereco {
    private Long id;
    private String cep;
    private String rua;
    private String cidade;
    private String bairro;
    private String estado;
    private String uf;


}
