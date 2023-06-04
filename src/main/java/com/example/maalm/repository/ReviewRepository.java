package com.example.maalm.repository;

import com.example.maalm.entities.Maalm;
import com.example.maalm.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    public List<Review> findByMaalm(Maalm maalm);

}
