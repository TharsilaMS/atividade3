package service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class FallbackOrderMapper {

        private final String[] fallbackOrder;

        public FallbackOrderMapper(@Value("${app.cep.fallback-order}") String[] fallbackOrder) {
            this.fallbackOrder = fallbackOrder;
        }

        public String[] getFallbackOrder() {
            return fallbackOrder;
        }
    }


