package com.eren.jobservice.dto;


import com.eren.jobservice.entity.Job;
import com.eren.jobservice.external.Company;
import lombok.Data;

@Data
public class JobWithCompanyDTO {

    private Job job;
    private Company company;
}
