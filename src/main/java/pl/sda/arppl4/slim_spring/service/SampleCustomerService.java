package pl.sda.arppl4.slim_spring.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.arppl4.slim_spring.model.Customer;
import pl.sda.arppl4.slim_spring.model.SampleCustomer;
import pl.sda.arppl4.slim_spring.repository.SampleCustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/sampleCustomer")
@AllArgsConstructor
public class SampleCustomerService {
    private final SampleCustomerRepository sampleCustomerRepository;
    public void addSampleCustomer(SampleCustomer sampleCustomer) {
        sampleCustomerRepository.save(sampleCustomer);
    }

    public List<SampleCustomer> getAllSampleCustomers() {
        return sampleCustomerRepository.findAll();

    }

    public void deleteById(Long identifier) {
        sampleCustomerRepository.deleteById(identifier);
    }

    public void updateSampleCustomer(SampleCustomer updatedData) {
        Long identifier = updatedData.getId();
        Optional<SampleCustomer> sampleCustomerOptional = sampleCustomerRepository.findById(identifier);
        if(sampleCustomerOptional.isPresent()){
            SampleCustomer editedSampleCustomer = sampleCustomerOptional.get();
            if (updatedData.getSample_type() != null) {
                editedSampleCustomer.setSample_type(updatedData.getSample_type());
            }
            if (updatedData.getRegister_code() != null) {
                editedSampleCustomer.setRegister_code(updatedData.getRegister_code());
            }
            sampleCustomerRepository.save(updatedData);
            log.info("Sample customer was updated");
            return;
        }
        throw new EntityNotFoundException("No sample with id: " + updatedData.getId() +"has been found");
    }
}







