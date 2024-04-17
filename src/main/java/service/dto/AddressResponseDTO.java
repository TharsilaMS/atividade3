package service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponseDTO {

        private String cep;
        private String street;
        private String neighborhood;
        private String city;
        private String state;

    }


