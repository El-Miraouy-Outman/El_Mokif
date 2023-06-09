package com.example.maalm.controller;

import com.example.maalm.Dto.ReviewDto;
import com.example.maalm.entities.Maalm;
import com.example.maalm.entities.Review;
import com.example.maalm.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class RevieController {
    private final ReviewService reviewService;
    @GetMapping("/{id}")
    public List<ReviewDto> findReviewByMaalm(@PathVariable Long id) throws Exception {
        return reviewService.findReviewByMaalm(id);
    }

    @PostMapping
    public Review saveReview(@RequestBody Review review) throws Exception {
        return reviewService.saveReview(review);
    }
    @PutMapping
    public Review updateReview(@RequestBody Review review) throws Exception {
        return reviewService.updateReview(review);
    }

    @GetMapping
    public List<Review> getAllReview() {
        return reviewService.getAllReview();
    }


    @GetMapping("/maalm/{id}/client/{idClient}")
    public Review getReviewByMaalmAndClient(@PathVariable Long id, @PathVariable Long idClient) throws Exception {
        return reviewService.getReviewByMaalmAndClient(id,idClient);
    }
}
