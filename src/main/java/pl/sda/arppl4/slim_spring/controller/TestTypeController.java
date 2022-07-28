package pl.sda.arppl4.slim_spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/testType")
@RequiredArgsConstructor
public class TestTypeController {
    private final TestTypeService testTypeService;



    public ResponseEntity<List<TestType>> list() {
        log.info("Received request: list");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(testTypeService.findAll());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TestType TestType) {
        log.info("Received request: create -> " + testType);
        testTypeService.addTestType(testType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long testTypeId) {
        log.info("Received request: delete -> " + testTypeId);
        testTypeService.deleteTestType(testTypeId);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable(name = "id") Long auserId, @RequestBody TestType testType) {
        log.info("Received request: update -> " + testType);
        testTypeService.update(testTypeId, testType);
    }

}
