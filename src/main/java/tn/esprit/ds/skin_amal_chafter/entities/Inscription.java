package tn.esprit.ds.skin_amal_chafter.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numInscription;

    private String numSemaine;
    @ManyToOne
    private Cours cours;

    @ManyToOne
    private Skieur skieurs;
}
