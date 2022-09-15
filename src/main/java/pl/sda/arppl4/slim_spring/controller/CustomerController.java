package pl.sda.arppl4.slim_spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.slim_spring.model.Customer;
import pl.sda.arppl4.slim_spring.model.DTO.AUserDTO;
import pl.sda.arppl4.slim_spring.model.DTO.CustomerDTO;
import pl.sda.arppl4.slim_spring.service.CustomerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
private final CustomerService customerService;

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer) {
        log.info("Customer adding method was requested" + customer);
        customerService.addCustomer(customer);
    }
    @GetMapping
    public List<CustomerDTO> customerList() {
        log.info("Listing all customers");
        return customerService.listAll();
    }
@DeleteMapping("/delete/{identifier}")
    public void deleteCustomer(@PathVariable(name = "identifier") Long identifier){
        customerService.deleteById(identifier);

}
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable(name = "id") Long customerId, @RequestBody CustomerDTO customer) {
        log.info("Received request: update -> " + customer);
        customerService.updateCustomer(customerId, customer);
    }
    }
