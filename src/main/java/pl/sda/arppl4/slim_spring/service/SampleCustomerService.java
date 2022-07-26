package pl.sda.arppl4.slim_spring.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.arppl4.slim_spring.model.SampleCustomer;
import pl.sda.arppl4.slim_spring.repository.SampleCustomerRepository;

import java.util.List;

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
}
