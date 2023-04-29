package tn.esprit.ds.skin_amal_chafter.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.ds.skin_amal_chafter.entities.*;

import java.util.List;

public interface IServiceSkieur {

    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);

    Skieur updateSkieur (Skieur skieur);
    void removeSkieur (Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur assignSkierToAbonnement(Long numSkieur, Long numAbon);
   // List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
   List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbon);
   List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(TypeCours typeCours, Support support, Couleur couleur);
    List<Skieur>AmalJPQL(@Param("support") Support support, @Param("nom") String nom);

    Skieur addSkierAndAssignToCourse(Skieur skier);

}
