package com.example.maalm.service;

import com.example.maalm.entities.Maalm;
import com.example.maalm.repository.MaalmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MaalmServiceImpl implements MaalmService {

    private final MaalmRepository maalmRepository;



    @Override
    public Maalm findByEmailAndPASS(String email, String code) throws Exception {
        Maalm maalm=maalmRepository.findByEmailAndPassword(email,code);
        if(maalm==null) return null;
        return maalm;
    }

    @Override
    public Maalm getMaalmByCni(String cni) throws Exception {
        Maalm maalm = maalmRepository.findByCin(cni);
        if (maalm == null) throw  new  Exception("maalm not fund");
        return maalm;
    }

    @Override
    public Maalm saveMaalm(Maalm maalm) {
        return maalmRepository.save(maalm);
    }

    @Override
    public Maalm updateMaalm(Maalm maalm) throws Exception {
        System.out.println(maalm);
        Maalm maalm1 = getMaalmByCni(maalm.getCin());
        BeanUtils.copyProperties(maalm1,maalm);
        if ((maalm1==null))throw new  Exception("maalm not fund");
        // update
        return maalmRepository.save(maalm);
    }

    @Override
    public Maalm findById(Long id) throws Exception {
        Maalm maalm=maalmRepository.findById(id).get();
        if (maalm==null) throw new  Exception("maalm not fund");
        return maalm;
    }

    @Override
    public boolean deleteMaalmById(Long id) throws Exception {
        maalmRepository.deleteById(id);
        return true;
    }


    @Override
    public List<Maalm> getAllMaalm() {
        List<Maalm> maalms = maalmRepository.findAll();
        return maalms;
    }
}
