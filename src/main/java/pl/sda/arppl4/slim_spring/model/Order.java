package pl.sda.arppl4.slim_spring.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String register_code;
    private String total_price;
    private String status;
    private LocalDateTime order_date;


    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;


}
