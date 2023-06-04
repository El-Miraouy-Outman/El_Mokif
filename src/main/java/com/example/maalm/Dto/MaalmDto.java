package com.example.maalm.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaalmDto {
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String password;
    private String adresse;
    private int reviewTotal;
    private boolean role;
    private List<ReviewDto> reviewList;
    private  List<PublicationDto> publication;
}
