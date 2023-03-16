package tn.esprit.ds.skin_amal_chafter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.entities.TypeAbonnement;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long> {
   /* @Query("select s from Skieur s where s.abonnements.typeAbon = ?1")
    List<Skieur> findByAbonnementsTypeAbon(TypeAbonnement typeAbonnement);*/
  // @Query("select s from Skieur s where s.abonnements.typeAbon = ?1")
    List<Skieur> findSkieursByAbonnements_TypeAbon(TypeAbonnement typeAbon);
}
