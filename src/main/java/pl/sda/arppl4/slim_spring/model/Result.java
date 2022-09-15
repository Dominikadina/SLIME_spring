package pl.sda.arppl4.slim_spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import pl.sda.arppl4.slim_spring.model.DTO.AUserDTO;
import pl.sda.arppl4.slim_spring.model.DTO.ResultDTO;

import javax.persistence.*;

@Data // Getter Setter ToString EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double testResult;

    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String comment;

    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private AUser aUser;

    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private SampleCustomer sampleCustomer;

    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private OrderItem orderItem;

    public ResultDTO mapToDTO() {
        return new ResultDTO(
                id,
                testResult,
                unit,
                status,
                comment

        );
    }


}
