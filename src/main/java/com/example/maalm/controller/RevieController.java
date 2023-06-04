package com.example.maalm.controller;

import com.example.maalm.Dto.ReviewDto;
import com.example.maalm.entities.Review;
import com.example.maalm.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
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
}
