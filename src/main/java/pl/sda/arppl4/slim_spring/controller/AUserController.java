package pl.sda.arppl4.slim_spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.slim_spring.model.AUser;
import pl.sda.arppl4.slim_spring.model.Result;
import pl.sda.arppl4.slim_spring.service.AUserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/auser")
@RequiredArgsConstructor
public class AUserController {
    private final AUserService auserService;



    public ResponseEntity<List<AUser>> list() {
        log.info("Received request: list");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(auserService.findAll());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody AUser auser) {
        log.info("Received request: create -> " + auser);
        auserService.addAUser(auser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long auserId) {
        log.info("Received request: delete -> " + auserId);
        auserService.deleteAUser(auserId);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable(name = "id") Long auserId, @RequestBody AUser auser) {
        log.info("Received request: update -> " + auser);
        auserService.update(auserId, auser);
    }
}

