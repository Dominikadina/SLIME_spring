package pl.sda.arppl4.slim_spring.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long idDTO;
    private String companyDTO;
    private String firstNameDTO;
    private String secondNameDTO;
    private String addressDTO;
    private String countryDTO;
    private String emailDTO;
    private String phoneNumberDTO;
    private String nipNumberDTO;
    private String loginDTO;
    private String passwordDTO;


}
