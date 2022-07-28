package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.OrderItem;
import pl.sda.arppl4.slim_spring.model.Result;
import pl.sda.arppl4.slim_spring.repository.OrderItemRepository;
import pl.sda.arppl4.slim_spring.repository.ResultRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll() {
        List<OrderItem> orderItemList = orderItemRepository.findAll();

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            orderItems.add(orderItem);
        }

        return orderItems;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }

    public void update(Long orderItemId, OrderItem editOrderItemInformation) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(orderItemId);
        if (orderItemOptional.isPresent()) {
            OrderItem orderItem = orderItemOptional.get();

            if(editOrderItemInformation.getApackage()!=null){
                orderItem.setApackage(editOrderItemInformation.getApackage());
            }
            if(editOrderItemInformation.getPrice()!=null){
                orderItem.setPrice(editOrderItemInformation.getPrice());
            }

            orderItemRepository.save(orderItem);
            return;
        }
        throw new EntityNotFoundException("Unable to find orderItem with id: " + orderItemId);
    }
}
