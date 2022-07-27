package pl.sda.arppl4.slim_spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String first_name;
    private String second_name;
    private String street;
    private String street_number;
    private String postal_code;
    private String city;
    private String country;
    private String email;
    private String phone_number;
    private String nip_number;
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
        this.first_name = first_name;
        this.second_name = second_name;
        this.street = street;
        this.street_number = street_number;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phone_number = phone_number;
        this.nip_number = nip_number;
        this.login = login;
        this.password = password;
        this.order = order;
        this.sampleCustomers = sampleCustomers;
    }
}
