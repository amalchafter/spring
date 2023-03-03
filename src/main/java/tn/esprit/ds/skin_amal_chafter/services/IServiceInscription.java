package tn.esprit.ds.skin_amal_chafter.services;

import tn.esprit.ds.skin_amal_chafter.entities.Inscription;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;

import java.util.List;

public interface IServiceInscription {
    List<Inscription> retrieveAllInscription();
    Inscription addInscription(Inscription inscription);

    Inscription updateInscription (Inscription inscription);
    void removeinscription (Long numInscription);
    Inscription retrieveInscription (Long numInscription);
}
