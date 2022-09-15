package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.DTO.TestTypeDTO;
import pl.sda.arppl4.slim_spring.model.TestType;
import pl.sda.arppl4.slim_spring.repository.TestTypeRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestTypeService {


        private final TestTypeRepository testTypeRepository;

    public List<TestTypeDTO> listAll() {
        List<TestType> testTypeList = testTypeRepository.findAll();
        return testTypeList.stream().map(TestType::mapToDTO).collect(Collectors.toList());
    }


        public void addTestType(TestType testTypes) {
            testTypeRepository.save(testTypes);
        }

        public void deleteTestType(Long testTypesId) {
            testTypeRepository.deleteById(testTypesId);
        }

        public void update(Long testTypeId, TestTypeDTO editTestTypesInformation) {
            Optional<TestType> testTypeOptional = testTypeRepository.findById(testTypeId);
            if (testTypeOptional.isPresent()) {
                TestType testType = testTypeOptional.get();

                if(editTestTypesInformation.getTestCodeDTO()!=null){
                    testType.setTestCode(editTestTypesInformation.getTestCodeDTO());
                }
                if(editTestTypesInformation.getTestNameDTO()!=null){
                    testType.setTestName(editTestTypesInformation.getTestNameDTO());
                }
                if(editTestTypesInformation.getStatusDTO()!=null){
                    testType.setStatus(editTestTypesInformation.getStatusDTO());
                }
                if(editTestTypesInformation.getMethodDTO()!=null){
                    testType.setMethod(editTestTypesInformation.getMethodDTO());
                }


                testTypeRepository.save(testType);
                return;
            }
            throw new EntityNotFoundException("Unable to find test type with id: " + testTypeId);
        }
}
