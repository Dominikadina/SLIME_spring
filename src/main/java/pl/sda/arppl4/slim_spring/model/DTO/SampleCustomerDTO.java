package pl.sda.arppl4.slim_spring.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleCustomerDTO {
    private Long idDTO;
    private String sampleCodeDTO;
    private String sampleTypeDTO;
    private LocalDateTime entryDateDTO;
    private LocalDateTime downloadDateDTO;
    private String registerCodeDTO;
}
