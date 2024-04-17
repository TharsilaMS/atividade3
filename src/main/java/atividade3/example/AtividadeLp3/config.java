package atividade3.example.AtividadeLp3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.Map;
public class config {

    @Configuration
    public class ExternalSystemConfig {
        @Value("${app.cep.api}")
        private String apiConfig;

        @Value("${app.cep.fallback-order}")
        private List<String> falbackOrder;

        @Bean
        public Map<String, ExternalCepRestService> externalSystemBean() {
            return Map.of(
                    "VIACEP",
                    new ViaCepRestServiceImpl(),
                    "CEPABERTO",
                    new CepAbertoServiceImpl(),
                    "BRASILAPI",
                    new BrasilApiRestServiceImpl()
            );
        }

        @Bean
        @ConditionalOnProperty(value = "app.cep.fallback", havingValue = "false" )
        public ExternalCepRestService externalCepRestService() {
            return externalSystemBean().get(apiConfig);
        }

        @Bean
        @ConditionalOnProperty(value = "app.cep.fallback", havingValue = "true" )
        public ExternalCepRestService externalCepRestServiceFallback() {
            return new FallBackRestImpl(this.falbackOrder);
        }
    }
}
