package pl.sda.arppl4.slim_spring.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.arppl4.slim_spring.model.Role;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AUserDTO {
    private Long idUser;
    private String fNameDTO;
    private String lNameDTO;
    private String emailDTO;
    private String loginDTO;
    private String passwordDTO;
    private Role roleDTO;

}
