package pl.sda.arppl4.slim_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arppl4.slim_spring.model.Order;

public interface OrderRepository extends JpaRepository <Order, Long> {
}
