package pl.sda.arppl4.slim_spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.sda.arppl4.slim_spring.model.DTO.AUserDTO;
import pl.sda.arppl4.slim_spring.model.DTO.CustomerDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data // Getter Setter ToString EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String firstName;
    private String secondName;
    private String address;
    private String country;
    private String email;
    private String phoneNumber;
    private String nipNumber;
    private String login;
    private String password;

    @CreationTimestamp
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Order> order;


    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<SampleCustomer> sampleCustomers;

    public CustomerDTO mapToDTO() {
        return new CustomerDTO(
                id,
                company,
                firstName,
                secondName,
                address,
                country,
                email,
                phoneNumber,
                nipNumber,
                login,
                password
        );
    }

}
