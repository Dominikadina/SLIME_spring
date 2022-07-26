package pl.sda.arppl4.slim_spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
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
@GetMapping("/list")
    public List<Order> getAllOrder(){
    log.info("List of orders was called");
    List<Order> list = orderService.getAllOrder();
    return list;

}
@DeleteMapping("/delete/{identifier}")
    public void deleteOrder(@PathVariable(name = "identifier") Long identifier){
    log.info("Delete order method ws called:" + identifier);
    orderService.deleteById(identifier);
}

}
