package model;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class Endereco {
    @Id
    private Long id;
    private String cep;
    private String rua;
    private String cidade;
    private String bairro;
    private String estado;
    private String uf;


}
