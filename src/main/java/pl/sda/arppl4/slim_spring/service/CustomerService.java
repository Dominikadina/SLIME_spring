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
            if (updatedData.getFirstName() != null) {
                editedCustomer.setFirstName(updatedData.getFirstName());
            }
            if (updatedData.getSecondName() != null) {
                editedCustomer.setSecondName(updatedData.getSecondName());
            }
            if (updatedData.getStreet() != null) {
                editedCustomer.setStreet(updatedData.getStreet());
            }
            if (updatedData.getStreetNumber() != null) {
                editedCustomer.setStreetNumber(updatedData.getStreetNumber());
            }
            if (updatedData.getPostalCode() != null) {
                editedCustomer.setPostalCode(updatedData.getPostalCode());
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
            if (updatedData.getPhoneNumber() != null) {
                editedCustomer.setPhoneNumber(updatedData.getPhoneNumber());
            }
            if (updatedData.getNipNumber() != null) {
                editedCustomer.setNipNumber(updatedData.getNipNumber());
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
