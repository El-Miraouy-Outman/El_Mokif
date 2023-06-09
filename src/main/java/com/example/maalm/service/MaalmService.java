package com.example.maalm.service;

import com.example.maalm.entities.Maalm;

import java.util.List;

public interface MaalmService {
    public  Maalm findByEmailAndPASS(String email,String code) throws Exception;

    public  Maalm getMaalmByCni(String cne) throws Exception;
    public  Maalm saveMaalm(Maalm maalm) throws Exception;
    public  Maalm updateMaalm(Maalm maalm) throws Exception;
    public  Maalm findById(Long id) throws Exception;

    public  boolean deleteMaalmById(Long id) throws Exception;
    public List<Maalm> getAllMaalm();

}
