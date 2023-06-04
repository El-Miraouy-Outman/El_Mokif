package com.example.maalm.repository;

import com.example.maalm.entities.Maalm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaalmRepository extends JpaRepository<Maalm,Long> {

    public  Maalm findByEmailAndPassword(String email,String pass);
    public  Maalm findByCin(String cne);
}

