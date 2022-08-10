package pl.sda.arppl4.slim_spring.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.slim_spring.model.SampleCustomer;
import pl.sda.arppl4.slim_spring.service.SampleCustomerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/SampleCustomer")
@AllArgsConstructor
public class SampleCustomerController {
    private final SampleCustomerService sampleCustomerService;

    @PostMapping("/add")
            public void addSampleCustomer(@RequestBody SampleCustomer sampleCustomer) {
        log.info("SampleCustomer adding method was requested" + sampleCustomer);
        sampleCustomerService.addSampleCustomer(sampleCustomer);
    }
    @GetMapping("/list")
    public List<SampleCustomer> getAllSampleCustomer(){
        log.info("List of samplecustomer was called");
        List<SampleCustomer> list = sampleCustomerService.getAllSampleCustomers();
        return list;
    }
    @DeleteMapping("/delete/{identifier}")
    public void deleteSampleCustomer(@PathVariable(name = "identifier") Long identifier) {
        log.info("Delete customer sample was called:" + identifier);
        sampleCustomerService.deleteById(identifier);
    }
    @PostMapping("/update")
    public void updateSampleCustomer(@RequestBody SampleCustomer sampleCustomer){
        log.info("Update of sample customer was called");
        sampleCustomerService.updateSampleCustomer(sampleCustomer);
    }
}
