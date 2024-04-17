package service.client;
import controller.response.CepAberto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class CepAbertoClient {
    private final String CEP_ABERTO_URL = "https://www.cepaberto.com/api/v3/cep?cep={cep}";

        private final RestTemplate restTemplate;

        public CepAbertoClient(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public CepAberto getAddressByCEP(String cep, String token) {
            String url = CEP_ABERTO_URL.replace("{cep}", cep);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", " Token token=94053b879c9114bc25de8d8f59d82db7 " + token);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<CepAberto> response = restTemplate.exchange(url, HttpMethod.GET, entity, CepAberto.class);
            return response.getBody();
        }
    }


