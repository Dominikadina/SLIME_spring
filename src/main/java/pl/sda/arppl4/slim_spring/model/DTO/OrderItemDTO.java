package pl.sda.arppl4.slim_spring.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.arppl4.slim_spring.model.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private Long idOrderDTO;
    private APackage aPackageDTO;
    private Double priceDTO;

}
