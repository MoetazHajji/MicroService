package com.example.serviceanalyse.Services;

import com.example.serviceanalyse.Entities.Sample;
import com.example.serviceanalyse.Interfaces.ISample;
import com.example.serviceanalyse.Repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleService implements ISample {

    private final SampleRepository sampleRepository;


    @Override
    public Sample addOrUpdateSample(Sample sample) {
       return sampleRepository.save(sample);


    }

    @Override
    public void removeSample(int idSample) {
        sampleRepository.deleteById(idSample);
    }

    @Override
    public Sample retriveSample(int idSample) {
        return sampleRepository.findById(idSample).orElse(null);
    }
    @Override
    public List<Sample> retrieveAllSample() {

        return  sampleRepository.findAll();

    }







}
