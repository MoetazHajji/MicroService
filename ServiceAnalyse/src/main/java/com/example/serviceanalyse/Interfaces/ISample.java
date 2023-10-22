package com.example.serviceanalyse.Interfaces;

import com.example.serviceanalyse.Entities.Sample;

import java.util.List;

public interface ISample {
    Sample addOrUpdateSample(Sample sample);

    void removeSample(int idSample);

    Sample retriveSample(int idSample);

    List<Sample> retrieveAllSample();
}
