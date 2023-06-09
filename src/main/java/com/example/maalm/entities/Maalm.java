package com.example.maalm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Maalm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy = "maalm",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviewList;
    @OneToMany(mappedBy ="maalm",cascade = CascadeType.ALL)
    @JsonIgnore
    //@ToString.Exclude
    private  List<Publication> publication;


}
