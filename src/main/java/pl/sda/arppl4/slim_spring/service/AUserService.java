package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.AUser;
import pl.sda.arppl4.slim_spring.model.Result;
import pl.sda.arppl4.slim_spring.repository.AUserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AUserService {
    private final AUserRepository auserRepository;

    public List<AUser> findAll() {
        List<AUser> auserList = auserRepository.findAll();

        List<AUser> ausers = new ArrayList<>();
        for (AUser auser : auserList) {
            ausers.add(auser);
        }

        return ausers;
    }


    public void addAUser(AUser auser) {
        auserRepository.save(auser);
    }

    public void deleteAUser(Long auserId) {
        auserRepository.deleteById(auserId);
    }

    public void update(Long auserId, AUser editauserInformation) {
        Optional<AUser> auserOptional = auserRepository.findById(auserId);
        if (auserOptional.isPresent()) {
            AUser auser = auserOptional.get();

            if(editauserInformation.getFirstName()!=null){
                auser.setFirstName(editauserInformation.getFirstName());
            }
            if(editauserInformation.getLastName()!=null){
                auser.setLastName(editauserInformation.getLastName());
            }
            if(editauserInformation.getEmail()!=null){
                auser.setEmail(editauserInformation.getEmail());
            }
            if(editauserInformation.getPassword()!=null){
                auser.setPassword(editauserInformation.getPassword());
            }
            if(editauserInformation.getLogin()!=null){
                auser.setLogin(editauserInformation.getLogin());
            }
            if(editauserInformation.getRole()!=null){
                auser.setRole(editauserInformation.getRole());
            }

            auserRepository.save(auser);
            return;
        }
        throw new EntityNotFoundException("Unable to find auser with id: " + auserId);
    }


}
