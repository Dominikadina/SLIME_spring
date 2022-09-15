package pl.sda.arppl4.slim_spring.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.arppl4.slim_spring.model.AUser;
import pl.sda.arppl4.slim_spring.model.Customer;
import pl.sda.arppl4.slim_spring.model.DTO.AUserDTO;
import pl.sda.arppl4.slim_spring.model.DTO.SampleCustomerDTO;
import pl.sda.arppl4.slim_spring.model.SampleCustomer;
import pl.sda.arppl4.slim_spring.repository.SampleCustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/sampleCustomer")
@AllArgsConstructor
public class SampleCustomerService {
    private final SampleCustomerRepository sampleCustomerRepository;
    public void addSampleCustomer(SampleCustomer sampleCustomer) {
        sampleCustomerRepository.save(sampleCustomer);
    }

    public List<SampleCustomerDTO> listAll() {
        List<SampleCustomer> sampleCustomerList = sampleCustomerRepository.findAll();
        return sampleCustomerList.stream().map(SampleCustomer::mapToDTO).collect(Collectors.toList());
    }

    public void deleteById(Long identifier) {
        sampleCustomerRepository.deleteById(identifier);
    }

    public void updateSampleCustomer(Long sampleCustomerId, SampleCustomerDTO updateSampleCustomer) {

        Optional<SampleCustomer> sampleCustomerOptional = sampleCustomerRepository.findById(sampleCustomerId);
        if(sampleCustomerOptional.isPresent()){
            SampleCustomer sampleCustomer = sampleCustomerOptional.get();

            if (updateSampleCustomer.getSampleCodeDTO() != null) {
                sampleCustomer.setRegisterCode(updateSampleCustomer.getSampleCodeDTO());
            }
            if (updateSampleCustomer.getSampleTypeDTO() != null) {
                sampleCustomer.setSampleType(updateSampleCustomer.getSampleTypeDTO());
            }
            if (updateSampleCustomer.getEntryDateDTO() != null) {
                sampleCustomer.setEntryDate(updateSampleCustomer.getEntryDateDTO());
            }
            if (updateSampleCustomer.getDownloadDateDTO() != null) {
                sampleCustomer.setDownloadDate(updateSampleCustomer.getDownloadDateDTO());
            }
            if (updateSampleCustomer.getRegisterCodeDTO() != null) {
                sampleCustomer.setRegisterCode(updateSampleCustomer.getRegisterCodeDTO());
            }
            sampleCustomerRepository.save(sampleCustomer);
            log.info("Sample customer was updated");
            return;
        }
        throw new EntityNotFoundException("No sample with id: " + updateSampleCustomer.getIdDTO() +"has been found");
    }
}







