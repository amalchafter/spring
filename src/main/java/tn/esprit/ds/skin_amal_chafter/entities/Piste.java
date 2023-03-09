package tn.esprit.ds.skin_amal_chafter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Piste {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long numPiste;
    private String nomPiste;
    @Enumerated(EnumType.STRING)
   private  Couleur couleur;
    private int logueur;
   private int pente;
    @ManyToMany(mappedBy = "pistes",cascade =CascadeType.REMOVE)
    @JsonIgnore
    private List<Skieur> skieurs ;

}