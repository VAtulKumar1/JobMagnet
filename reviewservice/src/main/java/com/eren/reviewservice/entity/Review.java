package com.eren.reviewservice.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewerName;
    private Long rating;
    private Long companyId;
    private String comment;
}
