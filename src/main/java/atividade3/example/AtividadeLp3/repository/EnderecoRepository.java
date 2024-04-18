package atividade3.example.AtividadeLp3.repository;

import atividade3.example.AtividadeLp3.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco  findByCep(String cep);

}
