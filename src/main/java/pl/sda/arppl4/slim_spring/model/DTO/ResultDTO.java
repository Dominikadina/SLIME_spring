package pl.sda.arppl4.slim_spring.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.arppl4.slim_spring.model.Status;
import pl.sda.arppl4.slim_spring.model.Unit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {
    private Long idDTO;
    private Double testResultDTO;
    private Unit unitDTO;
    private Status statusDTO;
    private String commentDTO;
}
