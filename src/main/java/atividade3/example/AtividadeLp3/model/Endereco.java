package atividade3.example.AtividadeLp3.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String logradouro;
    @Column
    private Integer numero;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
}
