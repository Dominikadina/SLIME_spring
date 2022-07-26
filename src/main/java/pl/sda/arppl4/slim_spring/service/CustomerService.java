package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.Customer;
import pl.sda.arppl4.slim_spring.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();

    }

    public void deleteById(Long identifier) {
        customerRepository.deleteById(identifier);
    }

    public void updateCustomer(Customer updatedData) {
        Long identifier = updatedData.getId();
        Optional<Customer> customerOptional = customerRepository.findById(identifier);
        if (customerOptional.isPresent()) {
            Customer editedCustomer = customerOptional.get();
            if (updatedData.getCompany() != null) {
                editedCustomer.setCompany(updatedData.getCompany());
            }
        }
        customerRepository.save(updatedData);
        log.info("Customer was updated.");
        return;
    }
}
