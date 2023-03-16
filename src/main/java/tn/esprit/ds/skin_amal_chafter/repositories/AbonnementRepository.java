package tn.esprit.ds.skin_amal_chafter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.skin_amal_chafter.entities.Abonnement;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    Set<Abonnement> findAbonnementByTypeAbon(TypeAbonnement typeAbonnement);
    List<Abonnement> findAbonnementByDateDabutAndDateFin(LocalDate dateDebut,LocalDate dateFin);
}
