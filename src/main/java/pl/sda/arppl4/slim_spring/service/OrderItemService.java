package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.DTO.OrderItemDTO;
import pl.sda.arppl4.slim_spring.model.OrderItem;
import pl.sda.arppl4.slim_spring.model.Result;
import pl.sda.arppl4.slim_spring.repository.OrderItemRepository;
import pl.sda.arppl4.slim_spring.repository.ResultRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public List<OrderItemDTO> listAll() {
        List<OrderItem> userList = orderItemRepository.findAll();
        return userList.stream().map(OrderItem::mapToDTO).collect(Collectors.toList());
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }

    public void update(Long orderItemId, OrderItemDTO editOrderItemInformation) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(orderItemId);
        if (orderItemOptional.isPresent()) {
            OrderItem orderItem = orderItemOptional.get();

            if(editOrderItemInformation.getAPackageDTO()!=null){
                orderItem.setApackage(editOrderItemInformation.getAPackageDTO());
            }
            if(editOrderItemInformation.getPriceDTO()!=null){
                orderItem.setPrice(editOrderItemInformation.getPriceDTO());
            }

            orderItemRepository.save(orderItem);
            return;
        }
        throw new EntityNotFoundException("Unable to find orderItem with id: " + orderItemId);
    }
}
