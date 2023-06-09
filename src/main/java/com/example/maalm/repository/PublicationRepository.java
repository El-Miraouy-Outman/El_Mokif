package com.example.maalm.repository;

import com.example.maalm.entities.Etat;
import com.example.maalm.entities.Maalm;
import com.example.maalm.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long> {
     public  List<Publication> findByMaalm(Maalm maalm);

     public  List<Publication> findByEtat(Etat etat);
}
