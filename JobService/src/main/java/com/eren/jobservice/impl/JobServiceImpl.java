package com.eren.jobservice.impl;

import com.eren.jobservice.JobRepository;
import com.eren.jobservice.JobService;
import com.eren.jobservice.entity.Job;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {


    private JobRepository jobRepository;


    @Override
    public Job create(Job job) {
        Job res=jobRepository.save(job);
        return res;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job updateJob(Job job, Long id) throws Exception {
        Optional<Job> res = jobRepository.findById(id);
        if(res.isPresent()){
            Job existingJob = res.get();
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setSalary(job.getSalary());
            existingJob.setLocation(job.getLocation());
            return jobRepository.save(existingJob);


        }
        else{
            throw new Exception("Job Not Found");
        }

    }

    @Override
    public Boolean deleteJob(Long id) throws Exception {
        Optional<Job> job = jobRepository.findById(id);
        if(job.isPresent()){
            jobRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }


    }
}
