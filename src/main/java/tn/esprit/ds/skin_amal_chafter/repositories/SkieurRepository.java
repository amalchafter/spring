package tn.esprit.ds.skin_amal_chafter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.ds.skin_amal_chafter.entities.*;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long> {
  @Query("select s from Skieur s where s.abonnements.typeAbon = ?1")

    List<Skieur> findSkieursByAbonnements_TypeAbon(TypeAbonnement typeAbon);
   //List<Skieur>findByInscriptionsCoursTypeCoursSupportAndPistesCouleur(TypeCours typeCours, Support support, Couleur couleur);

    @Query(value = "select* from skieur s \n" +
            "join abonnement a on s.abonnements_num_abon=a.num_abon\n" +
            "where a.type_abon=:type_abon",nativeQuery = true)

    List<Skieur> findSkieursByAbonnements_TypeAbonSQL(@Param("type_abon") TypeAbonnement typeAbon);
   List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(TypeCours typeCours, Support support, Couleur couleur);
    @Query (value="SELECT * from skieur s \n" +
            "JOIN inscription i ON i.skieurs_num_skieur=s.num_skieur\n" +
            "JOIN cours c ON c.num_cours=i.cours_num_cours\n" +
            "JOIN moniteur_cours mc ON mc.moniteur_num_moniteur =c.num_cours\n" +
            "JOIN moniteur m ON m.num_moniteur =mc.moniteur_num_moniteur\n" +
            "WHERE m.nomm=:nom AND c.support=:support",nativeQuery = true)
    List<Skieur>AmalSQL(@Param("support") Support support,@Param("nom") String nom);
    // jpql
   @Query("select i.skieurs from Inscription i " +
           "JOIN Moniteur m ON i.cours member of m.cours "+
           "WHERE m.nomM=:nom AND i.cours.support=:support")

   List<Skieur>AmalJPQL(@Param("support") Support support,@Param("nom") String nom);

}
