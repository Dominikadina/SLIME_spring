package pl.sda.arppl4.slim_spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.slim_spring.model.TestType;
import pl.sda.arppl4.slim_spring.repository.TestTypeRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestTypeService {


        private final TestTypeRepository testTypeRepository;

        public List<TestType> findAll() {
            List<TestType> testTypeList = testTypeRepository.findAll();

            List<TestType> testTypes = new ArrayList<>();
            for (TestType testType : testTypeList) {
                testTypes.add(testType);
            }

            return testTypes;
        }


        public void addTestType(TestType testTypes) {
            testTypeRepository.save(testTypes);
        }

        public void deleteTestType(Long testTypesId) {
            testTypeRepository.deleteById(testTypesId);
        }

        public void update(Long testTypeId, TestType editTestTypesInformation) {
            Optional<TestType> testTypeOptional = testTypeRepository.findById(testTypeId);
            if (testTypeOptional.isPresent()) {
                TestType testType = testTypeOptional.get();

                if(editTestTypesInformation.getTestCode()!=null){
                    testType.setTestCode(editTestTypesInformation.getTestCode());
                }
                if(editTestTypesInformation.getTestName()!=null){
                    testType.setTestName(editTestTypesInformation.getTestName());
                }
                if(editTestTypesInformation.getStatus()!=null){
                    testType.setStatus(editTestTypesInformation.getStatus());
                }
                if(editTestTypesInformation.getMethod()!=null){
                    testType.setMethod(editTestTypesInformation.getMethod());
                }


                testTypeRepository.save(testType);
                return;
            }
            throw new EntityNotFoundException("Unable to find test type with id: " + testTypeId);
        }
}
