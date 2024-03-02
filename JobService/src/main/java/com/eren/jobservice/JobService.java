package com.eren.jobservice;

import com.eren.jobservice.entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    Job create(Job job);
    List<Job> findAll();
    Optional<Job> getJobById(Long id);
    Job updateJob(Job job, Long id) throws Exception;
    Boolean deleteJob(Long id) throws Exception;
}
