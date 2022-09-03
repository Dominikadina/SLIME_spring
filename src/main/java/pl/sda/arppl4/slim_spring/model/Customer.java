package pl.sda.arppl4.slim_spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity

@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String firstName;
    private String secondName;
    private String street;
    private String streetNumber;
    private String postalCode;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;
    private String nipNumber;
    private String login;
    private String password;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Order> order;


    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<SampleCustomer> sampleCustomers;

    public Customer(Long id, String company, String first_name, String second_name, String street, String street_number, String postal_code, String city, String country, String email, String phone_number, String nip_number, String login, String password, Set<Order> order, Set<SampleCustomer> sampleCustomers) {
        this.id = id;
        this.company = company;
        this.firstName = firstName;
        this.secondName = secondName;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nipNumber = nipNumber;
        this.login = login;
        this.password = password;
        this.order = order;
        this.sampleCustomers = sampleCustomers;
    }
}
