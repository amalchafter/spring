package tn.esprit.ds.skin_amal_chafter.services;

import tn.esprit.ds.skin_amal_chafter.entities.Cours;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;

import java.util.List;
import java.util.Set;

public interface IServiceCours {
    List<Cours> retrieveAllCours();
    Cours addCours(Cours cours);

    Cours updateCours (Cours cours);
    void removeCours (Long numCours);
    Cours retrieveCours (Long numCours);
    Set<Cours> findCoursByInscriptionsSQL();
}
