package tn.esprit.ds.skin_amal_chafter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.ds.skin_amal_chafter.entities.Cours;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;

import java.util.Set;

public interface CoursRepository extends JpaRepository<Cours,Long> {

    @Query(value = "SELECT * FROM cours c" +
            "ORDER BY(SELECT COUNT(*) from inscription i where i.cours_num_cours=c.num_cours)",nativeQuery = true)
    Set<Cours> findCoursByInscriptionsSQL();

    @Query("select c from Cours c order by c.inscriptions.size")
    Set<Cours> findCoursByInscriptionsJPQL();



}
