package com.eren.jobservice.impl;

import com.eren.jobservice.JobRepository;
import com.eren.jobservice.JobService;
import com.eren.jobservice.dto.JobWithCompanyDTO;
import com.eren.jobservice.entity.Job;
import com.eren.jobservice.external.Company;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {


    private JobRepository jobRepository;
    private RestTemplate restTemplate;


    @Override
    public Job create(Job job) {
        Job res=jobRepository.save(job);
        return res;
    }

    @Override
    public List<JobWithCompanyDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JobWithCompanyDTO> jobsWithCompanyDTO = new ArrayList<>();

        for(Job job: jobs){
            Long companyId = job.getCompanyId();
            JobWithCompanyDTO jobWithCompany = new JobWithCompanyDTO();
            if(companyId!=null){
                Company company = restTemplate.getForObject("http://localhost:8081/companies/company/"+companyId
                        ,Company.class);
                jobWithCompany.setJob(job);
                jobWithCompany.setCompany(company);



            }
            jobsWithCompanyDTO.add(jobWithCompany);

        }


        return jobsWithCompanyDTO;
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
