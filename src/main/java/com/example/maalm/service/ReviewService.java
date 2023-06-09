package com.example.maalm.service;

import com.example.maalm.Dto.ReviewDto;
import com.example.maalm.entities.Maalm;
import com.example.maalm.entities.Review;

import java.util.List;

public interface ReviewService {
    public List<ReviewDto> findReviewByMaalm(Long id) throws Exception;
    public Review saveReview(Review review) throws Exception;
    public Review updateReview(Review review) throws Exception;

    List<Review> getAllReview();


    Review getReviewByMaalmAndClient(Long id, Long idClient) throws Exception;
}
