package com.example.maalm.service;

import com.example.maalm.entities.Maalm;
import com.example.maalm.entities.Review;
import com.example.maalm.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final MaalmService maalmService;
    private final ReviewRepository reviewRepository;
    @Override
    public List<Review> findReviewByMaalm(Long id) throws Exception {
        Maalm maalm1=maalmService.findById(3L);

        System.out.println("heeeeee---------"+maalm1);

        List<Review>  reviewList=new ArrayList<>();
        reviewList.addAll(maalm1.getReviewList());
        if (reviewList == null) return null;
        return reviewList;
    }

    @Override
    public Review saveReview(Review review) throws Exception {
        Maalm maalm = maalmService.findById(review.getIdReviewrs());
        maalm.getReviewList().add(review);
        review.setMaalm(maalm);
        //maalmService.saveMaalm(maalm);
        return reviewRepository.save(review);
    }
}
