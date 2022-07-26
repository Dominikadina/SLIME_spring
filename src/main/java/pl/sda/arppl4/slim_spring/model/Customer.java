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
    private String e_mail;
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

}
