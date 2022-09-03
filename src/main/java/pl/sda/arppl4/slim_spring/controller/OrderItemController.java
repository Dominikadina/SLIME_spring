package pl.sda.arppl4.slim_spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.slim_spring.model.OrderItem;
import pl.sda.arppl4.slim_spring.service.OrderItemService;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/orderitem")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;



    @GetMapping()
    public ResponseEntity<List<OrderItem>> list() {
        log.info("Received request: list");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderItemService.findAll());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OrderItem orderItem) {
        log.info("Received request: create -> " + orderItem);
        orderItemService.addOrderItem(orderItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long orderItemId) {
        log.info("Received request: delete -> " + orderItemId);
        orderItemService.deleteOrderItem(orderItemId);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable(name = "id") Long orderItemId, @RequestBody OrderItem orderItem) {
        log.info("Received request: update -> " + orderItem);
        orderItemService.update(orderItemId, orderItem);
    }
}
