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
        return maalmRepository.findByEmailAndPassword(email,code);
    }

    @Override
    public Maalm getMaalmByCni(String cni) throws Exception {
        Maalm maalm = maalmRepository.findByCin(cni);
        if (maalm == null) throw  new  Exception("maalm not fund");
        return maalm;
    }

    @Override
    public Maalm saveMaalm(Maalm maalm) throws Exception {

        if( maalmRepository.findByEmail(maalm.getEmail())!=null ||
            maalmRepository.findByCin(maalm.getCin())!=null)
            throw  new Exception("Utilisateur  déja existe");
        return maalmRepository.save(maalm);
    }

    @Override
    public Maalm updateMaalm(Maalm maalm) throws Exception {
        Maalm maalm1 = getMaalmByCni(maalm.getCin());
        BeanUtils.copyProperties(maalm,maalm1);
        if (maalm1==null)throw new  Exception("maalm not fund");
        return maalmRepository.save(maalm);
    }

    @Override
    public Maalm findById(Long id) throws Exception {
        return maalmRepository.findById(id).get();
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
