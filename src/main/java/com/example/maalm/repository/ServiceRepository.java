package com.example.maalm.repository;

import com.example.maalm.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
    public Service findByName(String name) ;

    }
