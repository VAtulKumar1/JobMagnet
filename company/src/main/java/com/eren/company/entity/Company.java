package com.eren.company.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="PDBCompany")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
}
