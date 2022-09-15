package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.DTO.ResultDTO;
import pl.sda.arppl4.slim_spring.model.Result;
import pl.sda.arppl4.slim_spring.repository.ResultRepository;


import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    public List<ResultDTO> listAll() {
        List<Result> resultList = resultRepository.findAll();
        return resultList.stream().map(Result::mapToDTO).collect(Collectors.toList());
    }


    public void addResult(Result result) {
        resultRepository.save(result);
    }

    public void deleteResult(Long resultId) {
        resultRepository.deleteById(resultId);
    }

    public void update(Long resultId, ResultDTO editResultInformation) {
        Optional<Result> resultOptional = resultRepository.findById(resultId);
        if (resultOptional.isPresent()) {
            Result result = resultOptional.get();

           if(editResultInformation.getTestResultDTO()!=null){
                result.setTestResult(editResultInformation.getTestResultDTO());
            }
            if(editResultInformation.getCommentDTO()!=null){
                result.setComment(editResultInformation.getCommentDTO());
            }
            if(editResultInformation.getStatusDTO()!=null){
                result.setStatus(editResultInformation.getStatusDTO());
            }
            if(editResultInformation.getUnitDTO()!=null){
                result.setUnit(editResultInformation.getUnitDTO());
            }


            resultRepository.save(result);
            return;
        }
        throw new EntityNotFoundException("Unable to find result with id: " + resultId);
    }
}
