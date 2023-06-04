package com.example.maalm.Dto;

import com.example.maalm.entities.Maalm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private Long idReviewrs;
    private int review;

    private MaalmDto maalm;
    private Long idClient;
}
