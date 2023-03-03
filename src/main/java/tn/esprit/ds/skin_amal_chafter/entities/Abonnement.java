package tn.esprit.ds.skin_amal_chafter.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  long numAbon;
    private LocalDate dateDabut;
   private  LocalDate dateFin;

   private  Float prixAbon;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement TypeAbon;
}
