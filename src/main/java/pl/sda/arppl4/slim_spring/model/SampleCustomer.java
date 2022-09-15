package pl.sda.arppl4.slim_spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.sda.arppl4.slim_spring.model.DTO.SampleCustomerDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SampleCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sampleCode;
    private String sampleType;
    private LocalDateTime entryDate;
    private LocalDateTime downloadDate;
    private String registerCode;
    @CreationTimestamp
    private String registerDate;



    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Customer customer;

    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private AUser aUser;

    @OneToMany(mappedBy = "sampleCustomer", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<Result> result ;

    @OneToMany(mappedBy = "sampleCustomer", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<OrderItem> orderItem ;

    public SampleCustomerDTO mapToDTO() {
        return new SampleCustomerDTO(
                id,
                sampleCode,
                sampleType,
                entryDate,
                downloadDate,
                registerCode
        );
    }



// To zmieniam, bo mamy relacje ManyToOne to customer
 //   @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
 //   @EqualsAndHashCode.Exclude
 //   private Set<SampleCustomer> sampleCustomers;
}
