package pl.sda.arppl4.slim_spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sda.arppl4.slim_spring.model.DTO.AUserDTO;
import pl.sda.arppl4.slim_spring.model.DTO.TestTypeDTO;

import javax.persistence.*;
import java.util.Set;

@Data // Getter Setter ToString EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String testCode;
    private String testName;
    private String method;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "testType", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<OrderItem> orderItem;

    public TestTypeDTO mapToDTO() {
        return new TestTypeDTO(
                id,
                testCode,
                testName,
                method,
                status
        );
    }


}
