package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.AUser;
import pl.sda.arppl4.slim_spring.model.DTO.AUserDTO;
import pl.sda.arppl4.slim_spring.repository.AUserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AUserService {
    private final AUserRepository auserRepository;

    public List<AUserDTO> listAll() {
        List<AUser> userList = auserRepository.findAll();
        return userList.stream().map(AUser::mapToDTO).collect(Collectors.toList());
    }


    public void addAUser(AUser auser) {
        auserRepository.save(auser);
    }

    public void deleteAUser(Long auserId) {
        auserRepository.deleteById(auserId);
    }

    public void update(Long auserId, AUserDTO editauserInformation) {
        Optional<AUser> auserOptional = auserRepository.findById(auserId);
        if (auserOptional.isPresent()) {
            AUser auser = auserOptional.get();

            if(editauserInformation.getFNameDTO()!=null){
                auser.setFirstName(editauserInformation.getFNameDTO());
            }
            if(editauserInformation.getLNameDTO()!=null){
                auser.setLastName(editauserInformation.getLNameDTO());
            }
            if(editauserInformation.getEmailDTO()!=null){
                auser.setEmail(editauserInformation.getEmailDTO());
            }
            if(editauserInformation.getPasswordDTO()!=null){
                auser.setPassword(editauserInformation.getPasswordDTO());
            }
            if(editauserInformation.getLoginDTO()!=null){
                auser.setLogin(editauserInformation.getLoginDTO());
            }
            if(editauserInformation.getRoleDTO()!=null){
                auser.setRole(editauserInformation.getRoleDTO());
            }

            auserRepository.save(auser);
            return;
        }
        throw new EntityNotFoundException("Unable to find auser with id: " + auserId);
    }


}
