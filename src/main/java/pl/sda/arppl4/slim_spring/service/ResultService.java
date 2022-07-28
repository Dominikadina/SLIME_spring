package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.Result;
import pl.sda.arppl4.slim_spring.repository.ResultRepository;


import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    public List<Result> findAll() {
        List<Result> resultList = resultRepository.findAll();

        List<Result> results = new ArrayList<>();
        for (Result result : resultList) {
            results.add(result);
        }

        return results;
    }

    public void addResult(Result result) {
        resultRepository.save(result);
    }

    public void deleteResult(Long resultId) {
        resultRepository.deleteById(resultId);
    }

    public void update(Long resultId, Result editResultInformation) {
        Optional<Result> resultOptional = resultRepository.findById(resultId);
        if (resultOptional.isPresent()) {
            Result result = resultOptional.get();

           if(editResultInformation.getTestResult()!=null){
                result.setTestResult(editResultInformation.getTestResult());
            }
            if(editResultInformation.getComment()!=null){
                result.setComment(editResultInformation.getComment());
            }
            if(editResultInformation.getStatus()!=null){
                result.setStatus(editResultInformation.getStatus());
            }
            if(editResultInformation.getUnit()!=null){
                result.setUnit(editResultInformation.getUnit());
            }


            resultRepository.save(result);
            return;
        }
        throw new EntityNotFoundException("Unable to find result with id: " + resultId);
    }
}
