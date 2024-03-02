package com.eren.jobservice.controller;


import com.eren.jobservice.JobService;
import com.eren.jobservice.dto.JobWithCompanyDTO;
import com.eren.jobservice.entity.Job;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobController {

    private final JobService jobService;


    @PostMapping("/job")
    public ResponseEntity<Job> create(@RequestBody Job job){
        Job response =jobService.create(job);
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<JobWithCompanyDTO>> findAll(){
        List<JobWithCompanyDTO> response =jobService.findAll();
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Optional<Job> response =jobService.getJobById(id);
        if(response.isPresent()){
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/update")
    public ResponseEntity<Job> updateJob(@RequestParam Long id,@RequestBody Job job) throws Exception {
        Job updated =jobService.updateJob(job,id);
        return new ResponseEntity<>(updated, HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteJob(@RequestParam Long id) throws Exception {
        Boolean response =jobService.deleteJob(id);
        if(response){
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

}
