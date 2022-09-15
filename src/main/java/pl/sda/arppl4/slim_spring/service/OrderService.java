package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pl.sda.arppl4.slim_spring.model.DTO.OrderDTO;
import pl.sda.arppl4.slim_spring.model.Order;
import pl.sda.arppl4.slim_spring.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public void addOrder(Order order) {

        orderRepository.save(order);
    }

    public List<OrderDTO> listAll() {
        List<Order> userList = orderRepository.findAll();
        return userList.stream().map(Order::mapToDTO).collect(Collectors.toList());
    }

    public void deleteById(Long identifier) {

        orderRepository.deleteById(identifier);
    }

    public void updateOrder(Long orderId, OrderDTO updatedData) {

        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()){
        Order editedOrder = orderOptional.get();
        if (updatedData.getRegisterCodeDTO() != null) {
            editedOrder.setRegisterCode(updatedData.getRegisterCodeDTO());
        }
        if (updatedData.getTotalPriceDTO() != null) {
            editedOrder.setTotalPrice(updatedData.getTotalPriceDTO());
        }
        if (updatedData.getStatusDTO() != null) {
            editedOrder.setStatus(updatedData.getStatusDTO());
        }
        if (updatedData.getRegisterCodeDTO() != null) {
            editedOrder.setRegisterCode(updatedData.getRegisterCodeDTO());
        }
        orderRepository.save(editedOrder);
        log.info("Order was updated");
        return;
    }
    throw new EntityNotFoundException ("No order with id: " + updatedData.getIdDTO() + "has been found");
}
    }

