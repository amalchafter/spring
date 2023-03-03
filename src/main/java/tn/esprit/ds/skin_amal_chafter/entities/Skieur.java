package tn.esprit.ds.skin_amal_chafter.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long numSkieur;
    private String nomS;
   private String prenomS;
   private LocalDate dateNaissance;
   private String ville;
   @OneToOne(cascade = CascadeType.REMOVE)
   private Abonnement abonnements;

   @OneToMany(mappedBy = "skieurs")
   private List<Inscription> inscriptions;

   @ManyToMany
   private List<Piste> pistes;


}
