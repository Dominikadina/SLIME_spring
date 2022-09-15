package pl.sda.arppl4.slim_spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.slim_spring.model.DTO.AUserDTO;
import pl.sda.arppl4.slim_spring.model.DTO.OrderDTO;
import pl.sda.arppl4.slim_spring.model.Order;
import pl.sda.arppl4.slim_spring.service.OrderService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
private final OrderService orderService;

@PostMapping("/add")
    public void addOrder(@RequestBody Order order){
    log.info("Adding method was called" + order);
    orderService.addOrder(order);
}
@GetMapping
    public List<OrderDTO> userList() {
        log.info("Listing all orders");
        return orderService.listAll();
    }
@DeleteMapping("/delete/{identifier}")
    public void deleteOrder(@PathVariable(name = "identifier") Long identifier){
    log.info("Delete order method was called:" + identifier);
    orderService.deleteById(identifier);
}
@PatchMapping("/{id}")
@ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable(name = "id") Long orderId, @RequestBody OrderDTO order) {
        log.info("Received request: update -> " + order);
        orderService.updateOrder(orderId, order);
    }
}
