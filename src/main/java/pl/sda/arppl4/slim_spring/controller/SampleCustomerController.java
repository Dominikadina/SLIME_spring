package pl.sda.arppl4.slim_spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.slim_spring.model.DTO.AUserDTO;
import pl.sda.arppl4.slim_spring.model.DTO.ResultDTO;
import pl.sda.arppl4.slim_spring.model.DTO.SampleCustomerDTO;
import pl.sda.arppl4.slim_spring.model.Result;
import pl.sda.arppl4.slim_spring.model.SampleCustomer;
import pl.sda.arppl4.slim_spring.service.ResultService;
import pl.sda.arppl4.slim_spring.service.SampleCustomerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/sampleCustomer")
@RequiredArgsConstructor
public class SampleCustomerController {
    private final SampleCustomerService sampleCustomerService;

    @GetMapping
    public List<SampleCustomerDTO> userList() {
        log.info("Listing all sample of customers");
        return sampleCustomerService.listAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addSampleCustomer(@RequestBody SampleCustomer sampleCustomer) {
        log.info("Received request: create -> " + sampleCustomer);
        sampleCustomerService.addSampleCustomer(sampleCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long sampleCustomerId) {
        log.info("Received request: delete -> " + sampleCustomerId);
        sampleCustomerService.deleteById(sampleCustomerId);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable(name = "id") Long sampleCustomerId, @RequestBody SampleCustomerDTO sampleCustomer) {
        log.info("Received request: update -> " + sampleCustomer);
        sampleCustomerService.updateSampleCustomer(sampleCustomerId, sampleCustomer);
    }

}
