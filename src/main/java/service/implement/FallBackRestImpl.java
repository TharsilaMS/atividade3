package service.implement;

import lombok.RequiredArgsConstructor;
import model.Endereco;
import service.implement.BrasilApiImplement;
import service.implement.CepAbertoImplement;
import service.implement.ExternalCepRestService;
import service.implement.ViaCepImplement;

import java.util.List;
@RequiredArgsConstructor

public class FallBackRestImpl implements ExternalCepRestService {

        private final List<String> fallbackOrder;
        private List<ExternalCepRestService> externalImpl =
                List.of(
                        new CepAbertoImplement(),
                        new BrasilApiImplement(),
                        new ViaCepImplement()
                );

        @Override
        public Endereco searchByCep(String cep) {

            Endereco response = null;
            for (ExternalCepRestService externalService : externalImpl) {
                try {
                    response = externalService.searchByCep(cep);
                    break;
                } catch (RuntimeException ex) {
                    continue;
                }
            }
            return response;
        }

    }
