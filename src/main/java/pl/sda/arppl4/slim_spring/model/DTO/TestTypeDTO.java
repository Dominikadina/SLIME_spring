package pl.sda.arppl4.slim_spring.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.arppl4.slim_spring.model.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestTypeDTO {
    private Long idDTO;
    private String testCodeDTO;
    private String testNameDTO;
    private String methodDTO;
    private Status statusDTO;
}
