package com.eren.reviewservice.controller;


import com.eren.reviewservice.ReviewService;
import com.eren.reviewservice.entity.Review;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/reviews")
@AllArgsConstructor
public class ReviewController {


    private final ReviewService reviewService;


    @PostMapping
    public ResponseEntity<Review> createReview(@RequestParam Long companyId,@RequestBody Review review){
        Review response = reviewService.createReview(review);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviewByCompanyId(@RequestParam Long id){
        List<Review> response = reviewService.getReviewByCompanyId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) throws Exception {
        Review response = reviewService.getReviewById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }



    @PutMapping("/update/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review ,@PathVariable Long id) throws Exception {
        Review response = reviewService.updateReview(review,id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) throws Exception {
        Boolean response = reviewService.deleteReview(id);
        if(response){
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Not Found",HttpStatus.NOT_FOUND);

    }
}
