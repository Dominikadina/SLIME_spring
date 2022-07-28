package pl.sda.arppl4.slim_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arppl4.slim_spring.model.OrderItem;
import pl.sda.arppl4.slim_spring.model.Result;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
