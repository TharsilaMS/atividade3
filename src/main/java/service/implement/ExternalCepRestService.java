package service.implement;

import model.Endereco;

public interface ExternalCepRestService {
    Endereco searchByCep(String cep);
}
