package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.Customer;
import pl.sda.arppl4.slim_spring.model.DTO.CustomerDTO;
import pl.sda.arppl4.slim_spring.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<CustomerDTO> listAll() {
        List<Customer> userList = customerRepository.findAll();
        return userList.stream().map(Customer::mapToDTO).collect(Collectors.toList());
    }

    public void deleteById(Long identifier) {
        customerRepository.deleteById(identifier);
    }

    public void updateCustomer(Long customerId, CustomerDTO updatedData) {

        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer editedCustomer = customerOptional.get();

            if (updatedData.getCompanyDTO() != null) {
                editedCustomer.setCompany(updatedData.getCompanyDTO());
            }
            if (updatedData.getFirstNameDTO() != null) {
                editedCustomer.setFirstName(updatedData.getFirstNameDTO());
            }
            if (updatedData.getSecondNameDTO() != null) {
                editedCustomer.setSecondName(updatedData.getSecondNameDTO());
            }
            if (updatedData.getAddressDTO() != null) {
                editedCustomer.setAddress(updatedData.getAddressDTO());
            }
            if (updatedData.getCountryDTO() != null) {
                editedCustomer.setCountry(updatedData.getCountryDTO());
            }
            if (updatedData.getEmailDTO() != null) {
                editedCustomer.setEmail(updatedData.getEmailDTO());
            }
            if (updatedData.getPhoneNumberDTO() != null) {
                editedCustomer.setPhoneNumber(updatedData.getPhoneNumberDTO());
            }
            if (updatedData.getNipNumberDTO() != null) {
                editedCustomer.setNipNumber(updatedData.getNipNumberDTO());
            }
            if (updatedData.getLoginDTO() != null) {
                editedCustomer.setLogin(updatedData.getLoginDTO());
            }
            if (updatedData.getPasswordDTO() != null) {
                editedCustomer.setPassword(updatedData.getPasswordDTO());
            }

        customerRepository.save(editedCustomer);
        log.info("Customer was updated.");
        return;
    }

throw new EntityNotFoundException("No customer with id: " + updatedData.getIdDTO() +"has been found");
}
}
