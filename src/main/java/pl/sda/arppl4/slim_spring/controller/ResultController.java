package pl.sda.arppl4.slim_spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.slim_spring.model.DTO.AUserDTO;
import pl.sda.arppl4.slim_spring.model.DTO.ResultDTO;
import pl.sda.arppl4.slim_spring.model.Result;
import pl.sda.arppl4.slim_spring.service.ResultService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/result")
@RequiredArgsConstructor

public class ResultController {
    private final ResultService resultService;



    @GetMapping
    public List<ResultDTO> userList() {
        log.info("Listing all users");
        return resultService.listAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Result result) {
        log.info("Received request: create -> " + result);
        resultService.addResult(result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long resultId) {
        log.info("Received request: delete -> " + resultId);
        resultService.deleteResult(resultId);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable(name = "id") Long resultId, @RequestBody ResultDTO result) {
        log.info("Received request: update -> " + result);
        resultService.update(resultId, result);
    }
}
