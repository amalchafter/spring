package tn.esprit.ds.skin_amal_chafter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.skin_amal_chafter.entities.Moniteur;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;

public interface MoniteurRepository extends JpaRepository<Moniteur,Long> {
}
