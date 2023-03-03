package tn.esprit.ds.skin_amal_chafter.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Cours {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long numCours;
    @Column
    private int niveau;
    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;
    @Enumerated(EnumType.STRING)
   private Support support;
   private float prix;
    private int creneau;
    @Transient
   private int sc;
    @OneToMany(mappedBy = "cours",cascade = CascadeType.REMOVE)
    private List<Inscription> inscriptions;
}
