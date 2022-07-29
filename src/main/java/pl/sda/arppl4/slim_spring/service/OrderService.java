package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.Order;
import pl.sda.arppl4.slim_spring.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public void addOrder(Order order) {

        orderRepository.save(order);
    }

    public List<Order> getAllOrder() {

        return orderRepository.findAll();
    }

    public void deleteById(Long identifier) {

        orderRepository.deleteById(identifier);
    }

    public void updateOrder(Order updatedData) {
        Long identifier = updatedData.getId();
        Optional<Order> orderOptional = orderRepository.findById(identifier);
        if (orderOptional.isPresent()){
        Order editedOrder = orderOptional.get();
        if (updatedData.getRegisterCode() != null) {
            editedOrder.setRegisterCode(updatedData.getRegisterCode());
        }
        if (updatedData.getTotalPrice() != null) {
            editedOrder.setTotalPrice(updatedData.getTotalPrice());
        }
        if (updatedData.getStatus() != null) {
            editedOrder.setStatus(updatedData.getStatus());
        }
        if (updatedData.getRegisterCode() != null) {
            editedOrder.setRegisterCode(updatedData.getRegisterCode());
        }
        orderRepository.save(updatedData);
        log.info("Order was updated");
        return;
    }
    throw new EntityNotFoundException ("No order with id: " + updatedData.getId() + "has been found");
}
    }

