package com.example.serviceanalyse.Repository;

import com.example.serviceanalyse.Entities.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample,Integer> {

}