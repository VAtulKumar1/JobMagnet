package com.eren.jobservice.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="PDBJobs")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private String salary;
    private Long companyId;
}
