package tn.esprit.ds.skin_amal_chafter.services;

import tn.esprit.ds.skin_amal_chafter.entities.Moniteur;
import tn.esprit.ds.skin_amal_chafter.entities.Piste;

import java.util.List;

public interface IServiceMoniteur {
    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addMoniteur(Moniteur moniteur);

    Moniteur updateMoniteur (Moniteur moniteur);
    void removeMoniteur (Long numMoniteur);
    Moniteur retrieveMoniteur (Long numMoniteur);

}
