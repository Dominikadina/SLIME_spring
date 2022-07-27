package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.Customer;
import pl.sda.arppl4.slim_spring.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
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
            if (updatedData.getFirst_name() != null) {
                editedCustomer.setFirst_name(updatedData.getFirst_name());
            }
            if (updatedData.getSecond_name() != null) {
                editedCustomer.setSecond_name(updatedData.getSecond_name());
            }
            if (updatedData.getStreet() != null) {
                editedCustomer.setStreet(updatedData.getStreet());
            }
            if (updatedData.getStreet_number() != null) {
                editedCustomer.setStreet_number(updatedData.getStreet_number());
            }
            if (updatedData.getPostal_code() != null) {
                editedCustomer.setPostal_code(updatedData.getPostal_code());
            }
            if (updatedData.getCity() != null) {
                editedCustomer.setCity(updatedData.getCity());
            }
            if (updatedData.getCountry() != null) {
                editedCustomer.setCountry(updatedData.getCountry());
            }
            if (updatedData.getEmail() != null) {
                editedCustomer.setEmail(updatedData.getEmail());
            }
            if (updatedData.getPhone_number() != null) {
                editedCustomer.setPhone_number(updatedData.getPhone_number());
            }
            if (updatedData.getNip_number() != null) {
                editedCustomer.setNip_number(updatedData.getNip_number());
            }
            if (updatedData.getLogin() != null) {
                editedCustomer.setLogin(updatedData.getLogin());
            }
            if (updatedData.getPassword() != null) {
                editedCustomer.setPassword(updatedData.getPassword());
            }

        customerRepository.save(updatedData);
        log.info("Customer was updated.");
        return;
    }

throw new EntityNotFoundException("No customer with id: " + updatedData.getId() +"has been found");
}
}
