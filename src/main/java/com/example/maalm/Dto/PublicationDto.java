package com.example.maalm.Dto;

import com.example.maalm.entities.Etat;
import com.example.maalm.entities.Maalm;
import com.example.maalm.entities.Service;
import com.example.maalm.entities.TypeService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PublicationDto {
    private Long id;
    private  String description;
    private Date datecreation;
    private MaalmDto maalm;
    private TypeService type;
    private Etat etat;
    private ServiceDto service;
}
