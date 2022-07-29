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

    private String registerCode;
    private String totalPrice;
    private String status;
    private LocalDateTime orderDate;


    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<OrderItem> orderItem;




}
