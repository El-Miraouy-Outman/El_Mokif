package com.example.maalm.entities;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private  String description;
     @Temporal(TemporalType.TIMESTAMP)
     private Date datecreation;
     @ManyToOne
     private Maalm maalm;
     @Enumerated(EnumType.STRING)
     private TypeService type;
     @Enumerated(value = EnumType.STRING)
     private  Etat etat;
     @ManyToOne
    private Service service;
}
