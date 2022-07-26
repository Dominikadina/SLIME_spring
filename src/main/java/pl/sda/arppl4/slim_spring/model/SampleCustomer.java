package pl.sda.arppl4.slim_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

    private String sample_code;
    private String sample_type;
    private LocalDateTime entry_date;
    private LocalDateTime download_date;
    private String register_code;
    private String register_date;


    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<SampleCustomer> sampleCustomers;
}
