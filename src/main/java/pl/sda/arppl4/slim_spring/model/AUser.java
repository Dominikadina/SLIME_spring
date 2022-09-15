package pl.sda.arppl4.slim_spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import pl.sda.arppl4.slim_spring.model.DTO.AUserDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data // Getter Setter ToString EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "aUser", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<SampleCustomer> sampleCustomers;

    @OneToMany(mappedBy = "aUser", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<Result> result;



    public AUserDTO mapToDTO() {
        return new AUserDTO(
                id,
                firstName,
                lastName,
                email,
                login,
                password,
                role
        );
    }
}
