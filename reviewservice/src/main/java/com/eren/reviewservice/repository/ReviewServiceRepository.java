package com.eren.reviewservice.repository;

import com.eren.reviewservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewServiceRepository extends JpaRepository<Review,Long> {


    List<Review> findAllByCompanyId(Long id);
}
