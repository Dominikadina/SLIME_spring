package pl.sda.arppl4.slim_spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.slim_spring.model.Customer;
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
@GetMapping("/list")
    public List<Customer> getAllCustomers() {
    log.info("List of customer was called");
    List<Customer> list = customerService.getAllCustomers();
    return list;

}
@DeleteMapping("/delete/{identifier}")
    public void deleteCustomer(@PathVariable(name = "identifier") Long identifier){
        customerService.deleteById(identifier);

}
@PostMapping("/update")
    public void updateCustomer(@RequestBody Customer customer){
log.info("Method of customer update was called");
customerService.updateCustomer(customer);
}
    }
