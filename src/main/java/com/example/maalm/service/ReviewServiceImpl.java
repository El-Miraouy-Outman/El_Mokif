package com.example.maalm.service;

import com.example.maalm.Dto.MaalmDto;
import com.example.maalm.Dto.ReviewDto;
import com.example.maalm.entities.Maalm;
import com.example.maalm.entities.Review;
import com.example.maalm.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final MaalmService maalmService;
    private final ReviewRepository reviewRepository;
    @Override
    public List<ReviewDto> findReviewByMaalm(Long id) throws Exception {
        Maalm maalm1=maalmService.findById(id);
        List<Review>  reviewList=maalm1.getReviewList();
        List<ReviewDto> liste=reviewList.stream()
                .map(rev->{
                    Maalm maalmDto=rev.getMaalm();
                    MaalmDto maalmDto1=MaalmDto.builder().build();
                    BeanUtils.copyProperties(maalmDto,maalmDto1);
                    ReviewDto review=ReviewDto.builder().maalm(maalmDto1).build();
                    BeanUtils.copyProperties(rev,review);
                    System.out.println(rev.getMaalm().getCin());
                    System.out.println(review.getMaalm().getCin());
                    return  review;
                }
        ).collect(Collectors.toList());
        return liste;
    }

    @Override
    public Review saveReview(Review review) throws Exception {
        Maalm maalm = maalmService.findById(review.getIdReviewrs());
        review.setMaalm(maalm);
        return reviewRepository.save(review);
    }
}
