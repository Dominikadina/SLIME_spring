package pl.sda.arppl4.slim_spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data // Getter Setter ToString EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private APackage apackage;
    private Double price;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private SampleCustomer sampleCustomer;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private TestType testType;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Order order;

    @OneToMany(mappedBy = "orderItem", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<Result> result ;

}
